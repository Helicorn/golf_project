<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>

<jsp:include page="/WEB-INF/views/includes/header.jsp" />
<link rel="stylesheet" type="text/css" href="/resources/css/header.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/ranking.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/scorecard_list.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/scorecard_write.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/board.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/foot.css" />
<br>
<script src="/resources/js/jquery.js"></script>

<%-- 스코어카드 게시판 글수정페이지 본문 --%>

<script>
	function check(){
		if($.trim($('#sc_title').val()) == ''){
			alert('제목을 입력하세요');
			$('#sc_title').val('').focus();
			return false;
		}
		if($.trim($('#sc_cont').val()) == ''){
			alert('내용을 입력하세요');
			$('#sc_cont').val('').focus();
			return false;
		}
	}
</script>

<article class="scboardwrite_main">
<br>
	<span class="rank_title_1" id="rank_tag">
		게시글 수정
	</span>
	<hr style="padding:0.5px; background-color:grey; width:1300px; margin-left:	4%; border:0; margin-top:20px;">
	<div class="scwrite_wrap">
	<form method="post" action="scorecard_edit_ok" onsubmit="return check();" enctype="multipart/form-data">
		 <%-- 히든값 전달 --%>
	    <input type="hidden" name="sc_no" value="${sb.sc_no }"> <%-- 번호가 전달 --%>
	    <input type="hidden" name="page" value="${page }"> <%-- 페이지 쪽나누기에서 책갈피 기능을 구현하기 위해 히든으로 쪽번호 전달 --%>
		<table class="sc_t">
			<tr height="0%">
				<td><input type="hidden" name="sc_id" class="sc_text" id="sc_id" readonly value="${id }"></td>			
			</tr>
			
			<tr height="10%">
				<td width="50%">
					<input type="text" id="playdate_output" readonly value="방문 날짜를 선택하세요">	
					<input type="date" name="sc_playdate" class="sc_date" id="sc_playdate" onchange="document.getElementById('playdate_output').value = this.value">
					<hr class="scwrite_hr">
				</td>
				<td width="60%">
					<input type="file" name="sc_file" id="sc_file" onchange="document.getElementById('file_route').value = this.value">
					<label for="sc_file" class="file_upload_button_sc">파일 등록</label>
					<input type="text" readonly id="file_route" value="스코어카드 사진을 올리세요">
					<hr class="scwrite_hr">
				</td>				
			</tr>
			
			<tr height="10%">
				<td colspan="2"> <input name="sc_title" class="sc_text" id="sc_title" value="${sb.sc_title }"><hr class="scwrite_hr"></td>			
			</tr>
		
			<tr height="70%">
				<td colspan="2"><textarea name="sc_cont" class="sc_text" id="sc_cont">${sb.sc_cont }</textarea><hr class="scwrite_hr"></td>
			</tr>
			
			
			<tr height="10%">
				<td>
					<input type="submit" name="sc_submit" class="submitBtn" id="sc_submit" value="글쓰기">
					
				</td>
				<td>
					<input type="button" name="sc_list" class="submitBtn" id="sc_list" value="목록" onclick="location='scorecard_list?page=${page}'">
				</td>
			</tr>
		</table>
	
	</form>
	</div>
</article>

<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
<br>
