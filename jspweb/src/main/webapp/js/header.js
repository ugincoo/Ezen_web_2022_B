console.log('헤더js열림');
let memberInfo = null;

// 로그인한 회원정보 호출 
getLogin();
function getLogin(){
	$.ajax({
		url : "/jspweb/login" ,
		async : false, // 동기화 변경 ( 비동기 -> 동기 )
		method : "get" , 
		success : (r) => {
			memberInfo = r;	// 응답 결과를 전역변수 옯기기 [ 다른 함수에서 사용하기 위해 ]
			
			let html = '';	// 1. html 구성 
			if( r.mid == null ){	// 2. 로그인 안했으면  (join -> null이 포함된 결과 가져오기 때문에 0 넣어줌))
			
				html +=  `<a href="/jspweb/member/signup.jsp">회원가입</a>`;
				html += ` <a href="/jspweb/member/login.jsp">로그인</a>`;
				
			}else{	// 3.로그인 했으면
				html+=
					`
					<div class="dropdown">
						<button class="hpimgbtn" type = "button" data-bs-toggle="dropdown">
							<img src="/jspweb/member/pimg/${ r.mimg == null ? '기본.jpg' : r.mimg }" class="hpimg">
						</button>
						<ul class="dropdown-menu"> <!-- 드롭다운시 표기되는 구역 -->
						    <li><a class="dropdown-item" href="/jspweb/member/info.jsp">내 프로필</a></li>
						    <li><a class="dropdown-item" href="#">${r.mpoint} point</a></li>
						    <li><a class="dropdown-item" href="#">친구목록</a></li>
						    <li><a class="dropdown-item" href="#">쪽지함</a></li>
						    <li><a class="dropdown-item" href="/jspweb/member/logout.jsp">로그아웃</a></li> 	
						 </ul>
					</div> <!-- 드롭다운 끝 -->
					${r.mid}님					
				`
			
				if( r.mid == 'admin'){ // 관리자이면 
					html += `<a href="/jspweb/admin/info.jsp">관리자</a>`
				}
		
			}
			document.querySelector(".submenu").innerHTML = html;
		}
	})
}

let 알림용소켓 = null;

if(memberInfo.mid == null){
	
}else {
	// JS 실행주체 = 클라이언트 // JAVA = 서버
	//1. JS[클라이언트]에서 소켓 생성
	알림용소켓 = new WebSocket('ws://localhost:8080/jspweb/alarm/'+memberInfo.mid);
	//2. 클라이언트 소켓내 필드의 이벤트 메소드 정의 
	알림용소켓.onopen = (e) => {console.log('알림용 서버소켓에 들어옴')}
	알림용소켓.onclose = (e) => {console.log('알림용 서버소켓을 나감')}
	알림용소켓.onerror = (e) => {console.log('알림용 서버소켓에 오류')}
	알림용소켓.onmessage = (e) => {onalarm(e)}
}

//
function onalarm(e){
	let msgbox = document.querySelector('.msgbox');
	
	msgbox.style.bottom = "40px";
	//4초 후에 자동 내려가기
	//n초 후에 이밴투 살행 setTimeout
	//n초 마다 이벤트 실행 setInerval
	setTimeout(()=>{msgbox.style.bottom = "-100px";},4000)
	//여러명에 채팅 요청하면 Dao 메소드 충돌 발생 
		// Dao 메소드 synchronized 키워드 사용
		// 스레드1 해당 메소드를 사용하고 있을때 [return 전 ] 다른 스레드2 해당 메소드에 대기상태 
		// 멀티스레드 : HttpServlet에 포함
	getcontent(); // 채팅 받으면 채팅방 새로고침하기 
}




