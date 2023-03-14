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
insert into member (mid,mpw,memail) values ('admin','qwe','admin@naver.com');
delete from member where mno=3;
select*from member;
/*
	테이블 설계 주의점
		1. 서로 다른 테이블간의 중복필드 x
        2. 관계[연결 pk -fk]는 예외 -> 무결성 유지를 위해 
			- 테이블당 pk 1개 이상 권장


*/

-- 아이디에 해당하는 회원정보+보유포인트
-- 1. 특정회원
select * from mpoint where mno=2;

-- 2. 보유포인트 [ 누적포인트 ]
select sum(mpamount) from mpoint where mno = 2;

-- 3. 아이디에 해당하는 회원의 보유 포인트 [join - 교집합찾기 (pk-fk)]
select * from member m , mpoint p where m.mno = p.mno; -- 다른 조건과 헷갈릴 수 있음
select * from member m natural join mpoint; -- natural join 자동으로 pk-fk 찾아서 join 해줌

-- 4. 조인 후 필요한 필드와 통계[ 두개 이상 필드를 출력시 그룹필수! ] -  모든 회원
select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as 보유포인트
 from member m, mpoint p 
 where m.mno = p.mno
 group by mno;
 
 -- 5. 특정회원 보유 포인트 + 회원정보
 select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as 보유포인트
 from member m, mpoint p 
 where m.mno = p.mno and m.mid='asdasd';
 -- 
 select * from member where mid='asdfsdfasdf';
-- 포인트 지급
insert into mpoint(mpcomment , mpamount,mno) values ('관리자', 10000,1);
insert into mpoint(mpcomment , mpamount,mno) values ('귀엽둥이포인트',5000,3);

-- 포인트 사용
insert into mpoint(mpcomment , mpamount,mno) values ('츄르구매',-3000,2);