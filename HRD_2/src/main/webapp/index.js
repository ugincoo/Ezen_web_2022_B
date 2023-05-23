console.log('열림');

function add(){	
	//1. 
	let sno = document.querySelector('.sno')
	if(sno.value == ""){
		alert('학생 번호가 입력 되지 않았습니다.');
		sno.focus();
		return false;
	}
	let ekor = document.querySelector('.ekor')
	if(ekor.value == ""){
		alert('국어 점수가 입력 되지 않았습니다.');
		ekor.focus();
		return false;
	}
	let emath = document.querySelector('.emath')
	if(emath.value == ""){
		alert('수학 점수가 입력 되지 않았습니다.');
		emath.focus();
		return false;
	}
	let eeng = document.querySelector('.eeng')
	if(eeng.value == ""){
		alert('영어 점수가 입력 되지 않았습니다.');
		eeng.focus();
		return false;
	}
	let ehist = document.querySelector('.ehist')
	if(ehist.value == ""){
		alert('역사 점수가 입력 되지 않았습니다.');
		ehist.focus();
		return false;
	}
	document.addForm.submit();
	alert('성적 등록이 되었습니다.');
}