//1. userbox / Logbox / monbox DOM객체 가져오기
let userbox= document.querySelector('.userbox')
let logbox = document.querySelector('.Logbox')
let monbox = document.querySelector('.monbox')
let logbox2 = document.querySelector('.Logbox2')
let u_bar = document.querySelector('.u_bar')
let m_bar = document.querySelector('.m_bar')

//*userbox[기본/처음]위치
let u_left = 10; //유저 위치
let m_left = 910; // 몬스터 위치
let u_hp = 100;
let m_hp = 100;
let u_attack = 1
let m_attack = 1

let user = {
	img :	'img/이동.png',
	left :	10,
	hp : 100,
	exp :	0,
	level :	1,
	power : 1 	
}

let monsters= [
	{m_img : '주황버섯.gif' , hp : 100, left : 910, exp: 100, power:1},
	{m_img : '주황버섯.gif' , hp : 200, left : 910, exp: 200, power:2},
	{m_img : '주황버섯.gif' , hp : 300, left : 910, exp: 300, power:3}
	]

//2. 문서 안에서 키 입력 이벤트
document.addEventListener('keydown',(e)=>{
	//console.log('키입력') 
	//console.log(e) //누른 키 이벤트 보여줌
	//console.log(e.keyCode)
	
	let key = e.keyCode;	//입력 된 키 코드를 변수에 저장
	if( key == 37 ){//왼쪽키
		u_left -= 10
		u_left = u_left < 0 ? 0 : u_left //만약에 차감된 왼쪽 좌표가 0보다 작으면 0 아니면 적용
	
	}else if( key == 39 ){//오른쪽키
		u_left +=10
		u_left = u_left > 910 ? 910 : u_left
		userbox.style.backgroundImage = `url("img/이동.png")`	 //이동 모션
		userbox.style.backgroundSize =	`75px`
		dis();
	}else if (key == 65 ){//a키 : 공격
		userbox.style.backgroundImage = `url("img/공격.png")`	 //공격 모션
		userbox.style.backgroundSize =	`100px`	
		attack();
	}
	
	userbox.style.left = `${u_left}px` //* 키 입력후에 css : left로 변경	
	//* 현재 좌표를 로그에 출력
	logbox.innerHTML = `<div> 캐릭터좌표 : ${u_left} </div>`
})
//2. 문서 안에서 키 떼었을때 이벤트 (멈춰있을때)
document.addEventListener('keyup',(e)=>{
	userbox.style.backgroundImage = `url("img/이동.png")`
	userbox.style.backgroundSize =	`75px`		
})

//3. 몬스터 이동 난수 [랜덤 -> 1초마다]
	// 특정 시간마다 실행 해주는 함수 : setInterval( () =>{}, 밀리초(1000/1초) )

setInterval( mon_moving , 1000 ) //1초

function mon_moving(){ //console.log('몬스터이동')
	//1. 난수 +- 10
	let rand =parseInt(Math.random()*40+1); //1~10사이 //이동거리
	let rand2 = parseInt(Math.random()*2); //0 or 1 // 이동방향
	if(rand2 == 1)m_left += rand // 만약에 1이면 오른쪽 이동 0이면 왼쪽이동
	else m_left -= rand // 아니면
	//2. 게임 화면에 고정
	if(m_left < 0 )m_left = 0;
	if(m_left > 910 )m_left = 910;
	//3.
	monbox.style.left = `${m_left}px` 
	//2.
	logbox2.innerHTML = `<div> 몬스터좌표 : ${m_left} </div>`
}




/*
	함수 형태
		1. 익명함수 : function 함수명(){ } -> 재호출 가능
		2. 익명함수 : function (){ }
		3. 람다식함수 : ( ) => { }
		4. 변수함수 : let 변수명 = () => {} -> 재호출 가능
	Math.random()
		 Math.random() : 0~1 사이의 실수 실행
		 Math.random()*10 : 0~10사이의 실수 실행

*/
//hp 함수 // hp 게이지 깎일때(유저, 몬스터)
function hp(){
		if(m_hp <=0){ //몬스터 0일시 안보이게
		document.querySelector('.monbox').style.display="none";
		return;	}
		
		if(u_hp <=0){ //유저 0일시 게임오버
		alert('game over');	
		return;}			
}
// 공격했을때 , hp 감소(난수 넣기)
function attack(i){

   let 거리 =  ( m_left-u_left ) 
   if( 거리 >=0 && 거리 <=80){
      m_hp-=20;
      m_bar.style.width =  `${m_hp }px`
   }
	hp();
}
/*공격 받을때 */ 
function dis(){
   let dis =  ( m_left-u_left ) 
   if( dis >=0 && dis <=80){
      u_hp-=10;
      u_bar.style.width =  `${u_hp }px`
   }
   hp();
}

function monster(i){
	let monster = document.querySelector('.monbox')
	monster.style.backgroundImage = `url(img/${monsters[i].img})`
	monster.style.left = `${monsters[i].left}`
	monster.style.top = `${monsters[i].top}`
	monster.style.width = `${monsters[i].hp}.px`
	}
