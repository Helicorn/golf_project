--골프 필드 클래스 테이블 생성
create table golf_class(
c_no number(38), --클래스 고유번호
c_kind varchar2(30), --필드 or 온라인 구분
c_title varchar2(200), --클래스명
c_teacher varchar2(50), --강사명(xxx프로)
c_gender varchar2(20), --강사 성별
c_phone varchar2(50), --클래스 전화번호
c_career varchar2(1000), --강사 소개 또는 경력사항
c_sprice varchar2(200), --필드 클래스 STANDARD 가격
c_srounding varchar2(100), -- STANDARD 라운딩 횟수
c_sdesc varchar2(1000), -- STANDARD 상세 설명
c_stime varchar2(30), -- STANDARD 1회당 레슨 시간(분)
c_dprice varchar2(200), --필드 클래스 DELUXE 가격
c_drounding varchar2(100), -- DELUXE 라운딩 횟수
c_ddesc varchar2(1000), -- DELUXE 상세 설명
c_dtime varchar2(30), -- DELUXE 1회당 레슨 시간(분)
c_pprice varchar2(200), --필드 클래스 PREMIUM 가격
c_prounding varchar2(100), -- PREMIUM 라운딩 횟수
c_pdesc varchar2(1000), -- PREMIUM 상세 설명
c_ptime varchar2(30), -- PREMIUM 1회당 레슨 시간(분)
c_online varchar2(200), --온라인 클래스 가격
c_odesc varchar2(1000), --온라인 클래스 상세 설명
c_otime varchar2(30), --온라인 클래스 수강기간
c_addr varchar2(200), --클래스 지역
c_image varchar2(200) --이미지 경로
);

--골프 클래스 고유번호 시퀀스 생성
create sequence cno_seq
start with 1 --1부터 시작
increment by 1 --1씩 증가
nocache; --임시 메모리를 사용하지 않겠다는 의미.

--골프 클래스 insert
insert into golf_class values(
cno_seq.NEXTVAL, 
'필드',
'답답한 연습장이 아닌 필드에서 모든 골프 레슨을 펼쳐 드립니다.',
'이광용',
'남성',
'010-8850-2098',
'안녕하세요 진심은 통한다 ! 이광용 프로입니다.
진심을 다해 노력하며 열심히 알려드리겠습니다.',
'640,000',
'1',
'1. 라운딩 시작 1시간전 연습장 레슨\r\n
2. 비디오 분석\r\n
3.라운딩 후 피드백\r\n
4. 연습방법 고지\r\n',
'360',
'3,500,000',
'5',
'1. STANDARD와 동일\r\n
2. 끝장 레슨 1회 초대\r\n
(30만원 상당)',
'210',
'5,700,000',
'10',
'1. STANDARD와 동일\r\n
2. 끝장레슨 2회 무료 초대\r\n
(60만원 상당)',
'420',
null,
null,
null,
'경기도 용인',
'/resources/images/class/1_2.jpg'
);

select * from golf_class;

commit;

--------------------필요하면 사용하시오-----------------------

--골프 클래스 테이블 drop
drop table golf_class;

--골프 클래스 고유번호 시퀀스 drop
drop sequence cno_seq;