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

CREATE TABLE room (
	roomnum     int(7)     NOT NULL auto_increment, -- idx
    hotelnum	int(10)		NOT NULL,
	hotelname   VARCHAR(100)  NOT NULL, -- hotelname
	roomname    VARCHAR(50)  NOT NULL, -- roomname
	roomimg     VARCHAR(255) default '/image/noImg.png', -- roomimg
	maxppl      int(7)      NOT NULL, -- maxppl
	intro       VARCHAR(255) NULL,     -- intro
	price       int(7)      NOT NULL, -- price
	convenience CHAR(2)      NOT NULL,  -- convenience
    constraint room_roomnum_pk primary key(roomnum)
);
drop table room;
desc room;
select * from room;

insert into room values(null, 1	,'hotel01', '별빛룸', null, '4', '어서오세여', 5000, 'Y');




