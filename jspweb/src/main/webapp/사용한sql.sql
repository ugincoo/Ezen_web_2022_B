-- create database jspweb;
use jspweb;

drop table if exists member;
create table member(
	mno 	int auto_increment primary key,
    mid		varchar(30) not null unique, -- 공백,중복 불가
    mpw		varchar(20) not null,
    mimg	longtext, -- 서버에 저장된 사진경로
    memail	varchar(100) not null unique
);
-- 친구 추가 기능
drop table if exists friend;
create table friend(
	fno			int auto_increment primary key,
	ffrom		int ,
	fto 		int ,
    foreign key (ffrom) references member(mno) on delete set null, -- 친구가 탈퇴하면 공백
    foreign key (fto) references member(mno)  on delete set null
);
-- 포인트 기능
drop table if exists mpoint;
create table mpoint(
	mpno 		int	auto_increment primary key,
    mpcomment	varchar(1000) not null,
    mpamount 	int default 0,
    mpdate 		datetime default now(),
    mno 		int,
    foreign key (mno) references member (mno) on delete set null
);