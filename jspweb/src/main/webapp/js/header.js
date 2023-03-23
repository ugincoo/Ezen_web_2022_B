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





