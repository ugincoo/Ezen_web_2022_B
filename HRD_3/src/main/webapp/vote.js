console.log("열림");

function vote(){
	console.log('눌림');
	// 1. 폼 가져오기
	let f = document.voteForm;
	// 2. 유효성 검사
	if(f.v_jumin.value == ""){		
		alert('주민번호가 입력되지 않았습니다!');
		f.v_jumin.focus();
		return false;
	}
	if(f.v_name.value == ""){		
		alert('성명이 입력되지 않았습니다!');
		f.v_name.focus();
		return false;
	}
	if(f.m_no.value == ""){		
		alert('후보번호가 입력되지 않았습니다!');
		f.m_no.focus();
		return false;
	}
	if(f.v_time.value == ""){		
		alert('투표시간이 입력되지 않았습니다!');
		f.v_time.focus();
		return false;
	}
	if(f.v_area.value == ""){		
		alert('투표장소 입력되지 않았습니다!');
		f.v_area.focus();
		return false;
	}
	if(f.v_confirm.value == ""){		
		alert('유권자확인이 입력되지 않았습니다!');
		f.v_confirm.focus();
		return false;
	}
	
	//2. class로 가져오기
	/*let v_jumin = document.querySelector('.v_jumin')
	if(v_jumin == ""){
		alert('주민번호가 입력되지 않았습니다!');
		v_jumin.focus();
		return false;
	}
	let v_name = document.querySelector('.v_name')
	if(v_name == ""){
		alert('성명이 입력되지 않았습니다!');
		v_name.focuss();
		return false;
	}
	let m_no = document.querySelector('.m_no')
	if(m_no == ""){
		alert('후보번호가 입력되지 않았습니다!');
		m_no.focuss();
		return false;
	}
	let v_time = document.querySelector('.v_time')
	if(v_time == ""){
		alert('투표시간이 입력되지 않았습니다!');
		v_time.focuss();
		return false;
	}
	let v_area = document.querySelector('.v_area')
	if(v_area == ""){
		alert('투표장소가 입력되지 않았습니다!');
		v_area.focuss();
		return false;
	}
	*/
	// 폼 전송
	f.submit();
	alert('투표하기 정보가 정상적으로 등록 되었습니다.');
}

function votereset(){
	console.log('리셋눌림');	
	alert('정보를 지우고 처음부터 다시 입력합니다!');
	let f = document.voteForm;
	f.reset();
	f.v_jumin.focus();
	
}
	