if(memberInfo.mid ==  null){
	alert('로그인 하고 이용해주세요');
	location.href = "/jspweb/member/login.jsp"
}
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.mimg').src = `/jspweb/member/pimg/${memberInfo.mimg == null ? '기본.jpg': memberInfo.mimg}`

function setUpdate(){
	//1. 첨부파일 없을때 
/*	let info = {
		mpw : document.querySelector('.mpw').value,
		npw : document.querySelector('.npw').value,
		memail : document.querySelector('.memail').value,
	}
	console.log(info);
	*/
	//2. 첨부파일 있을때 
	let updateForm = document.querySelectorAll('.updateForm')[0];
 	let updateFormData =  new FormData(updateForm);
 	//3. 폼에 데이터 추가
 		//체크여부 확인
 	let defaultimg = document.querySelector('.defaultimg').checked;
	updateFormData.set("defaultimg",defaultimg);

 	
	
	$.ajax({
		url  : "/jspweb/member",
		method : "put",
		data : updateFormData,
		contentType:false,
		processData : false,
		success : (re) => {
			console.log('통신');
			console.log(re);
			if(re){
				alert('다시 로그인 해주세요.');
				location.href="/jspweb/member/logout.jsp"
			}else{
				alert('비밀번호가 다릅니다.')
			}
		}
		
		
	})
	
	
	
}