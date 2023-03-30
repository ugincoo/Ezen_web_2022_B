console.log('열림');

function join(){
	console.log(join);
	//유효성 검사

	if (document.joinform.custname.value == ""){
		alert('회원성명을 입력 해주세요');
		document.joinform.custname.focus();	//커서 깜빡거림
		return false;
	}	
	if (document.joinform.phone.value == ""){
		alert('전화번호를 입력 해주세요');
		document.joinform.phone.focus();	//커서 깜빡거림
		return false;
	}	
	if (document.joinform.address.value == ""){
		alert('주소 입력 해주세요');
		document.joinform.address.focus();	//커서 깜빡거림
		return false;
	}	
	if (document.joinform.joindate.value == ""){
		alert('가입날짜를 입력 해주세요');
		document.joinform.joindate.focus();	//커서 깜빡거림
		return false;
	}	
	if (document.joinform.grade.value == ""){
		alert('등급을 입력 해주세요');
		document.joinform.grade.focus();	//커서 깜빡거림
		return false;
	}	
	if (document.joinform.city.value == ""){
		alert('도시코드를 입력 해주세요');
		document.joinform.city.focus();	//커서 깜빡거림
		return false;
	}	
	//최종 - 유효성검사 끝
	document.joinform.submit(); //폼 전송
	alert('회원등록이 완료 되었습니다!');
	
	
}

