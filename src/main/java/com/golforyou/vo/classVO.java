package com.golforyou.vo;

import lombok.Data;

@Data
public class classVO {
	private int c_no; //클래스 고유번호
	private String c_title; //클래스명
	private String c_teacher; //클래스 강사명
	private String c_career; //강사 소개 또는 경력사항
	private String c_phone; //클래스 전화번호
	private String c_gender; //강사 성별
	private String c_kind; //클래스 종류
	private String c_info; //클래스 기본항목(라운딩 몇회)
	private String c_desc; //클래스 패키지 설명
	private String c_time; //1회당 레슨시간(분)
	private int c_count; //레슨 횟수
	private String c_price; //가격
	private String c_addr; //클래스 지역
	private String c_image; //이미지 경로
	
	
	//쪽나누기용 변수
	private int c_startrow; //시작행 번호
	private int c_endrow; //끝행 번호
	
	//검색기능
	private String c_find_field;
	private String c_find_name;

}
