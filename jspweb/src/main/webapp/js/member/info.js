console.log('열림');
console.log(memberInfo);


//1. header.js에서 ajax 동기식으로 회원정보 가져온 상태 [memberInfo]
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.memail').innerHTML = memberInfo.memail;
document.querySelector('.mimg').src = `/jspweb/member/pimg/${memberInfo.mimg == null ? '기본.jpg': memberInfo.mimg}`
document.querySelector('.mpoint').innerHTML = memberInfo.mpoint +'point';

//* 회원정보.js :  만약에 로그인이 안되어 있으면 불가능 [제어]
if(memberInfo.mid == null){
	alert('로그인하고 오세영');
	location.href = "/jspweb/member/login.jsp";
}

function deletebtn(){
	console.log('deletebtn');
	$.ajax({
		url : "/jspweb/member",
		method : "delete",
		data : {"mpw": document.querySelector('.mpw').value},
		success : (re)=>{
			console.log('통신'); console.log(re);
			if(re ){
				alert('탈퇴되셨습니다.');
				location.href = "/jspweb/member/logout.jsp";
			}else{
				alert('비밀번호가 다릅니다.');
			}
		}
	})
	
}



