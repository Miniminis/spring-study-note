-- BITCAMP 숙박 중개 플랫폼 프로젝트

create table user (
	idx int(7) not null auto_increment,
    id varchar(30) not null,
    pw varchar(30) not null,
    pnum varchar(30) not null,
    uname varchar(10) not null,
    constraint user_idx_pk primary key(idx)
);
desc user;
select * from user;

create table hotel (
	addr1 varchar(255),
    addr2 varchar(255),
    createdtime datetime,
    firstimage varchar(255),
    firstimage2 varchar(255),
    title varchar(255),
    tel varchar(20)
);

