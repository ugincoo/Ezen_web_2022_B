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

-- 카테고리 테이블[ 공지사항,커뮤니티,QnA,노하우 ] 
create table category(
	cno int auto_increment primary key,
    cname varchar(50) not null
);


-- 게시물 테이블 [ 번호, 제목,내용,첨부파일1개,작성일,조회수,좋아요수,싫어요수 ,작성자,카테고리 ]
create table board(
	bno int auto_increment primary key,
    btitle varchar(30) not null,
    bcontent longtext not null,
    bfile longtext,
    bdate datetime default now(),
    bview int default 0,
    bgood int default 0,
    bbad int default 0,
    mno int,
    cno int,
    foreign key (mno) references member(mno) on delete set null,
    foreign key (cno) references category (cno) on delete cascade
);
-- on delete cascade : pk가 삭제되면 fk도 같이 삭제 
-- on delete set null : pk가 삭제되면 fk는 null로 변경 
-- 생략				 : fk에 존재하는 식별키는 삭제 불가능

insert into category(cname)values('공지사항');
insert into category(cname)values('커뮤니티');
insert into category(cname)values('QnA');
insert into category(cname)values('노하우');
select * from category;
select * from board;

-- 댓글 테이블 [댓글내용,내용,작성일,인덱스(계층구분),작성자,게시물번호]
create table reply(
	rno int auto_increment primary key,
    rcontent longtext,
    rdate datetime default now(),
    rindex int default 0,-- 0이면 최상위계층 , 1~ 해당 댓글의 하위댓글
    mno int,
    bno int,
    foreign key (mno) references member(mno) on delete set null,
    foreign key (bno) references board(bno) on delete cascade
);

/*
	3번게시물 
		1번댓글			[rno = 1 , rindex = 0]
			3번댓글		[rno = 3 , rindex = 1] -- 부모 index 가져옴
			4번댓글		[rno = 4 , rindex = 1]
				6번댓글 	[rno = 6 , rindex = 4]
		2번댓글			[rno = 2 , rindex = 0]
        5번댓글			[rno = 5 , rindex = 0]
*/

insert into member (mid,mpw,memail) values ('admin','qwe','admin@naver.com');
delete from board where bno=2;
select*from member;

select count(*) from member where mid like '%g%' and mno = 2;
select*from member where mno limit 0,3;
select*from member where mid like '%a%' limit 3,3;
select * from member limit 0, 3;
/*
	테이블 설계 주의점
		1. 서로 다른 테이블간의 중복필드 x
        2. 관계[연결 pk -fk]는 예외 -> 무결성 유지를 위해 
			- 테이블당 pk 1개 이상 권장


*/
select * from member;
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


/*
	제품 1개당 사진1개 
		제품테이블(사진필드)
	제품 1개 사진 여러개
		제품테이블
        사진테이블
*/
/*
	제품테이블 / 사진테이블 / 찜(즐겨찾기)테이블 / 쪽찌테이블
*/

-- 제품테이블

create table product(
	pno int auto_increment primary key,		
    pname varchar(20) not null,
    pcomment text not null,
    pprice bigint not null ,
    pstate int default 1, -- 상태 [1:판매중 2:거래중 3:판매완료 등등]
    plat varchar(100) not null,-- 위도(x)
    plng varchar(100) not null ,-- 경도(y)
    pview int default 0,
    pdate datetime default now()
);
select * from product;
/*사진 테이블*/
create table plike(
	-- 누가 어떤제품을 찜 했는지
    plikno bigint auto_increment primary key,
    mno int,	-- 회원번호 누가
    pno int,	-- 어떤제품을
	foreign key (mno) references member (mno) on delete cascade,
  	foreign key (pno) references product (pno) on delete cascade
);
select * from plike;