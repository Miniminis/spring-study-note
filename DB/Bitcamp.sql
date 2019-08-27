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
	roomimg     VARCHAR(255) default '/image/noImg.png' not null, -- roomimg
	maxppl      int(7)      NOT NULL, -- maxppl
	intro       VARCHAR(255) NULL,     -- intro
	price       int(7)      NOT NULL, -- price
	convenience CHAR(2)      NOT NULL,  -- convenience
    availability char(2) 	not null,  
    constraint room_roomnum_pk primary key(roomnum)
);
drop table room;
desc room;
select * from room;

delete from room where roomnum=1;

insert into room values(null, 2222	,'hotel03', '반짝룸', default, '4', '어서오세여', 5000, 'Y', 'Y');
select * from room where hotelnum = 2579389 order by roomnum desc;

select * from room where roomnum=2;

select * from room;
update room set availability='N'  where roomnum=1;






CREATE TABLE `booking` (
  `IDX` int(6) NOT NULL AUTO_INCREMENT,
  `H_NAME` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `H_PHOTO` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `H_ADDRESS` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `R_NAME` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `START_DATE` datetime COLLATE utf8_bin DEFAULT NULL,
  `END_DATE` datetime COLLATE utf8_bin DEFAULT NULL,
  `BOOKING_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `R_PRICE` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `uId` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`IDX`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin
