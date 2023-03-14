console.log('열림');
//1.로그인
function login(){
	console.log('login열림')
	//
	let mid = document.querySelector('.mid').value;
	let	mpw = document.querySelector('.mpw').value;

	
	$.ajax({
		url :"/jspweb/login" ,
		method :"post" ,
		data : {"mid" : mid, "mpw":mpw} ,
		success : (r)=>{
			console.log('통신');
			console.log(r);
			if(r=='true'){
				location.href="/jspweb/index.jsp";				
			}else{
				document.querySelector('.checkconfirm').innerHTML='로그인 정보가 다릅니다.';}
		}
	})
	
}
//2.아이디 찾기
function findid(){
	console.log('찾기 눌림');
	let memail = document.querySelector('.memail').value;
	$.ajax({
		url :"/jspweb/find" ,
		method : "get",
		//"type":1 -> 아이디찾기 /"type":2 -> 비밀번호 찾기
		data :{"type":1,"memail":memail},
		success : (r) => {
			console.log('통신');console.log(r);
			if(r == 'false'){
				document.querySelector('.checkconfirm').innerHTML = '일치하는 회원 정보가 없습니다.'
			}else{
				document.querySelector('.checkconfirm').innerHTML = '회원님 ID : ' + r;
			}
		}
	})
}
//3. 비밀번호 찾기
function findpw(){
	console.log('찾기 눌림');
	
	let info = {
		type:2,
		mid : document.querySelector('.mid').value,
		memail : document.querySelector('.memail').value
	}

	$.ajax({
		url :"/jspweb/find" ,
		method : "get",
		data : info,
		success : (r) => {
			console.log('통신');console.log(r);
			if(r == 'false'){
				document.querySelector('.checkconfirm').innerHTML = '일치하는 회원 정보가 없습니다.'
			}else{
				document.querySelector('.checkconfirm').innerHTML = '임시비밀번호:' + r;
			} 
		}
	})
}