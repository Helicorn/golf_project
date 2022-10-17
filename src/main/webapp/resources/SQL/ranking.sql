create table class_ing(
m_id varchar2(50)
,c_no number(38)
);

create table golformembernew(
m_no number(38)
,m_name varchar2(50)
,m_id varchar2(50)
,m_pw varchar2(50)
,m_phone varchar2(50)
,m_addr varchar2(50)
,m_email varchar2(50)
,m_gender varchar2(10)
,m_file varchar2(50)
,m_date date
,m_state number(10)
,m_delcont varchar2(50)
,m_deldate date
);

create table golforboard(
b_no number(38)
,m_id varchar2(100)
,b_title varchar2(200)
,b_pwd varchar2(50)
,b_cont varchar2(4000)
,b_hit number(38)
,b_ref number(38)
,b_step number(38)
,b_level number(38)
,b_date date
,b_like number(38)
);

create table golf_class(
c_no number(38)
,c_title varchar2(100)
,c_teacher varchar2(20)
,c_career varchar2(200)
,c_phone varchar2(30)
,c_gender varchar2(20)
,c_kind varchar2(30)
,c_info varchar2(50)
,c_desc varchar2(200)
,c_time varchar2(100)
,c_count number(38)
,c_price varchar2(50)
,c_addr varchar2(50)
,c_image varchar2(200)
);

create table board(
b_no number(38)
,b_title varchar2(100)
,b_writer varchar2(100)
,b_cont varchar2(3000)
,b_view number(38)
,b_like number(38)
,b_bad number(38)
);

create table scboard(
sc_no number(38)
,sc_id varchar2(50)
,sc_name varchar2(50)
,sc_title varchar2(50)
,sc_playdate varchar2(50)
,sc_cont varchar2(4000)
,sc_file varchar2(100)
,sc_hit number(38)
,sc_ref number(38)
,sc_step number(38)
,sc_level number(38)
,sc_date date
);

create table score_card(
s_id varchar2(50)
,s_location varchar2(50)
,s_putting number(38)
,s_range number(38)
,s_handicap number(38)
,s_date varchar2(50)
,s_sort number(38)
,s_bestscore number(38)
,s_sumscore number(38)
);

create table ranking(
r_no number(38)
,r_id varchar2(50)
,r_sum number(38)
,r_maxrange number(38)
,r_province varchar2(50)
);

create table yeyag_list(
y_no number(38)
,y_name varchar2(100)
,y_list number(38)
,y_price number(38)
,y_usepeople number(38)
,y_area varchar2(100)
,y_img varchar2(100)
,y_info varchar2(100)
,y_url varchar2(2000)
);

drop table golformembernew;
drop table ranking;
drop table score_card;
drop table scboard;

commit;

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'aaaaa','id1111','1111','010-1111-1111','aaaaa','11@11.11','male',sysdate,1);

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'bbbbb','id2222','2222','010-2222-2222','bbbbb','22@22.22','male',sysdate,1);

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'ccccc','id3333','3333','010-3333-3333','ccccc','33@33.33','male',sysdate,1);

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'ddddd','id4444','4444','010-4444-4444','ddddd','44@44.44','male',sysdate,1);

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'eeeee','id5555','5555','010-5555-5555','eeeee','55@55.55','male',sysdate,1);

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'fffff','id6666','6666','010-6666-6666','fffff','66@66.66','male',sysdate,1);

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'ggggg','id77777','7777','010-7777-7777','ggggg','77@77.77','male',sysdate,1);

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'hhhhh','id8888','8888','010-8888-8888','hhhhh','88@88.88','male',sysdate,1);

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'iiiii','id9999','9999','010-9999-9999','iiiii','99@99.99','male',sysdate,1);

insert into golformembernew(m_no,m_name,m_id,m_pw,m_phone,m_addr,m_email,m_gender,m_date,m_state) 
values(m_no_seq.nextval,'jjjjj','id1010','1010','010-1010-1010','jjjjj','10@10.10','male',sysdate,1);

insert into ranking(r_no,r_id) values(rno_seq.nextval,'id1111');
insert into ranking(r_no,r_id) values(rno_seq.nextval,'id2222');
insert into ranking(r_no,r_id) values(rno_seq.nextval,'id3333');
insert into ranking(r_no,r_id) values(rno_seq.nextval,'id4444');
insert into ranking(r_no,r_id) values(rno_seq.nextval,'id5555');
insert into ranking(r_no,r_id) values(rno_seq.nextval,'id6666');
insert into ranking(r_no,r_id) values(rno_seq.nextval,'id7777');
insert into ranking(r_no,r_id) values(rno_seq.nextval,'id8888');
insert into ranking(r_no,r_id) values(rno_seq.nextval,'id9999');
insert into ranking(r_no,r_id) values(rno_seq.nextval,'id1010');





