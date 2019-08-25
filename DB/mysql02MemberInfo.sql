-- MemberInfo Table 

-- 테이블 생성
create table memberinfo (
	idx int(7) not null auto_increment,
	userid varchar(40) not null, 
    userpw varchar(32) not null,
    username varchar(20) not null,
    userphoto varchar(255) default '/image/noImg.png',
    regdate datetime default CURRENT_TIMESTAMP,
    verify char(2) default 'N',
    vericode varchar(30),
    constraint memberinfo_idx_pk PRIMARY KEY (idx),
    constraint memberinfo_userid_uk unique key (userid)
);

-- 테이블 데이터 확인 
desc memberinfo;
select * from memberinfo;
drop table memberinfo;
delete from memberinfo where idx=2;
insert into memberinfo values(null, "admin", "admin", "관리자", null, now(), 'Y', '1111');
insert into memberinfo values(null, "minis@minis", "1111", "손민희", null, now());
insert into memberinfo values(null, "munu@munu", "1111", "순무누", null, now());
insert into memberinfo values(null, "mama3", "1111", "손민희2", null, now());
insert into memberinfo values(null, "mama10", "1111", "손민희10", null, now());



select * from memberinfo;
desc memberinfo;

select count(*) from memberinfo;

select * from memberinfo order by idx desc limit 0, 3;
select * from memberinfo where username like '%손민희%' order by idx desc limit 0, 3;


delete from memberinfo where idx=1;
delete from memberinfo where userid="mama3";
select * from memberinfo

select userid, userpw, username, userphoto, regdate from memberinfo where userid="1@1" and userpw ="1"; 

drop table memberinfo;

select * from memberinfo where userid="minis";


select * from memberinfo where idx=2;

select * from memberinfo;

select * from memberinfo where username like '%십중팔구%' order by idx desc limit 0, 5;
select count(*) from memberinfo where userid like '%10@10%' and regdate between date_add(now(), interval -1 day) and now();

select * from memberinfo where userid="10@10" and regdate between date_add(now(), interval -1 day) and now()  order by idx desc limit 0, 5;
select * from memberinfo where regdate between date_add(now(), interval -1 day) and now();
select * from memberinfo where regdate between date_add(now(), interval -1 week) and now();
select * from memberinfo where regdate between date_add(now(), interval -1 month) and now();
select * from memberinfo where regdate between date_add(now(), interval -1 year) and now();
select * from memberinfo where regdate < now();

select * from memberinfo;

update memberinfo set userpw="0", username="삐리삐리", userphoto="noImg.png" where idx="2";

select * from memberinfo order by idx desc;
select * from memberinfo;
update memberinfo set verify = 1234 where vericode=325319606122 and userid='minhee4735@naver.com';
delete from memberinfo where idx=3;

select * from memberinfo where userid='minhee4735@naver.com'and username='1111';


-- --------------------------------------  GUEST BOOK  ----------------------------------------------------------------------
create table guestbook (
	gidx int(7) not null auto_increment,
	idx int(7) not null,
    gcontent varchar(255) not null, 
    gwritedate datetime default CURRENT_TIMESTAMP not null,
    gphoto varchar(255),
    constraint guestbook_gidx_pk PRIMARY KEY (gidx),
    constraint guestbook_idx_fk foreign key(idx) 
    references memberinfo(idx) on delete cascade
);

select * from guestbook;
desc guestbook;

create table gcomment (
	gcidx int(7) not null auto_increment,
	gidx int(7) not null,
    idx int(7) not null, 
    gccontent varchar(255) not null,
    gcwritedate datetime default CURRENT_TIMESTAMP not null,
    constraint gcomment_gcidx_pk PRIMARY KEY (gcidx),
    constraint gcomment_gidx_fk foreign key(gidx) 
    references guestbook(gidx) on delete cascade,
    constraint gcomment_idx_fk foreign key(idx) 
    references memberinfo(idx) on delete cascade
);

select * from gcomment;
desc gcomment;
select * from memberinfo, guestbook, gcomment; 


select * from memberinfo;
drop table guestbook;

-- --------------------------------------TRAVEL ----------------------------------------------------------------------
create table travel (
	tidx int(7) not null auto_increment,
	idx int(7) not null,
    tcontent varchar(255) not null,
    twritedate datetime default CURRENT_TIMESTAMP not null,
    tphoto varchar(255),
    constraint travel_tidx_pk PRIMARY KEY (tidx),
    constraint travel_idx_fk foreign key(idx) 
    references memberinfo(idx)
);

desc travel;


create table tcomment (
	tcidx int(7) not null auto_increment,
	tidx int(7) not null,
    idx int(7) not null, 
    tccontent varchar(255) not null,
    tcwritedate datetime default CURRENT_TIMESTAMP not null,
    constraint tcomment_tcidx_pk PRIMARY KEY (tcidx),
    constraint tcomment_tidx_fk foreign key(tidx) 
    references travel(tidx),
    constraint tcomment_idx_fk foreign key(idx) 
    references memberinfo(idx)
);


-- -------------------------------------- SQL 문 ----------------------------------------------------------------------

select * from memberinfo;
select * from guestbook;
select * from gcomment;
select * from travel;
select * from tcomment;

drop table memberinfo;
drop table guestbook;
drop table gcomment;
drop table travel;
drop table tcomment;