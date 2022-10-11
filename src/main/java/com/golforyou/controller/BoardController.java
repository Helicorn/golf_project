package com.golforyou.controller;
import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.golforyou.service.BoardService;
import com.golforyou.vo.boardVO;
import com.oreilly.servlet.MultipartRequest;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
		
	//게시판 작성
	@GetMapping("/board_write")
	public ModelAndView bbs_write(HttpServletRequest request) {
		int page=1;
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));
			
		}
		ModelAndView wm=new ModelAndView("board/board_write");//생성자 인자값으로 뷰페이지 경로 설정 : WEB-INF/views/board/board_write.jsp
		wm.addObject("page",page); //키,값 쌍으로 저장
		return wm;
		
	}//board_write()
	
	//게시판 글쓰기 저장
	//이진파일 업로드 하는 방법 3가지 이상이 있다고 함. 다른 방법도 찾아보기 
	@PostMapping("/board_write_ok")
	public String board_write_ok(boardVO b, HttpServletRequest request) throws Exception{
		String saveFolder=request.getRealPath("/resources/upload"); 
		//이진 파일 업로드 서버 경로 => 톰캣 WAS서버에 의해서 변경된 실제 경로 하위의 upload폴더
		
		int fileSize=5*1024*1024; //이진파일 업로드 최대 크기 
		MultipartRequest multi=null; //이진파일을 가져올 참조변수 
		
		multi=new MultipartRequest(request,saveFolder,fileSize,"UTF-8");
		
		String m_id=multi.getParameter("m_id");
		String b_title=multi.getParameter("b_title");
		String b_pwd=multi.getParameter("b_pwd");
		String b_cont=multi.getParameter("b_cont");
		
		File upFile= multi.getFile("b_file");//첨부한 이진파일을 가져온다. 
		
		if(upFile != null) { //첨부한 이진파일이 있는 경우 실행
			String fileName=upFile.getName();//첨부한 파일명
			Calendar cal=Calendar.getInstance();//캘린더는 추상클래스 new로 객체 생성을 못함**
			int year=cal.get(Calendar.YEAR);//년도값
			int month=cal.get(Calendar.MONTH)+1; //월값, +1 을 한 이유는 1월이 0 으로 반환 되기 때문
			int date=cal.get(Calendar.DATE); //일값
			
			String homedir=saveFolder+"/"+year+"-"+month+"-"+date; //오늘 날짜 폴더 경로 저장 
			File path01=new File(homedir);

			if(!(path01.exists())) {
				path01.mkdir(); //오늘 날짜 폴더 생성 
				//난수 발생하는 건, 매스 랜덤 정적 메서드, 자바유틸 랜덤 클래스 두가지 방법이 있다.
			}
			Random r = new Random(); //난수를 발생시키는 클랫 
			int random=r.nextInt(100000000); //0이상 1억 미만의 정수 숫자 난수 발생
			
			/*첨부 파일 확장자를 구함*/
			int index=fileName.lastIndexOf(".");
			//마침표를 맨 오른쪽부터 찾아서 가장 먼저 나오는 .의 위치 번호를  맨 왼쪽부터 카운터해서 반환 
			//첫 문자는 0부터 시작 
			String fileExtendsion=fileName.substring(index+1);//마침표 이후부터 마지막 문자까지 구함. 
			//즉 첨부파일  확장자를 구함. 
			String refileName="bbs"+year+month+date+random+"."+fileExtendsion;//새로운 파일명 저장 
			String fileDBName="/"+year+"-"+month+"-"+date+"/"+refileName;//데이터베이스에 저장될 레코드 값
			upFile.renameTo(new File(homedir+"/"+refileName)); //생성된 폴더에 변경된 파일명으로 실제 업로드 
			
			b.setB_file(fileDBName);
			
		}else {//첨부파일이 없는 경우 
			String fileDBName="";
			b.setB_file(fileDBName);
		}
		
		b.setB_title(b_title); b.setB_pwd(b_pwd); b.setB_cont(b_cont);
				
		this.boardService.insertBoard(b); //자료실 저장 
		
		return "redirect:/board_list";
	}//bbs_write_ok()
	
	
	
	//게시판 목록 
	@RequestMapping(value="/board_list",method=RequestMethod.GET)//get으로 접근하는 매핑주소를 처리 
	public String bbs_list(Model listM, HttpServletRequest request,@ModelAttribute boardVO b) {
				 
		int page=1;
		int limit=10;//한페이지에 보여지는 목록개수
		if(request.getParameter("page") != null) {
		page=Integer.parseInt(request.getParameter("page"));    //페이지 번호를 정수 숫자로 변경해서 저장      
		      }
		      String find_name=request.getParameter("find_name"); // 검색어
		      String find_field=request.getParameter("find_field"); //검색 필드
		        b.setFind_field(find_field);
		        b.setFind_name("%"+find_name+"%");

		      int totalCount=this.boardService.getRowCount(b);
		      //총레코드 개수,검색후 레코드 개수
		      
		      b.setStartrow((page-1)*10+1);//시작행번호
		      b.setEndrow(b.getStartrow()+limit-1);//끝행 번호
		      
		      List<boardVO> blist=this.boardService.getboardList(b); //검색 전후 목록
		      //목록
      
		      //총 페이지수
		      int maxpage=(int)((double)totalCount/limit+0.95);
		      //시작페이지(1,11,21 ..)
		      int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		      //현재 페이지에 보여질 마지막 페이지(10,20 ..)
		      int endpage=maxpage;
		      if(endpage>startpage+10-1) endpage=startpage+10-1;
		      
		      listM.addAttribute("blist",blist);
		      listM.addAttribute("page",page);
		      listM.addAttribute("startpage",startpage);
		      listM.addAttribute("endpage",endpage);
		      listM.addAttribute("maxpage",maxpage);
		      listM.addAttribute("listcount",totalCount);
		      listM.addAttribute("find_field",find_field);
		      listM.addAttribute("find_name",find_name);
		
			return "board/board_list";//뷰페이지 경로: /WEB-INF/views/board/board_list.jsp
		
		}//bbs_list()
	
	
	
	//게시판 수정
	
	//게시판 삭제 
	
}
