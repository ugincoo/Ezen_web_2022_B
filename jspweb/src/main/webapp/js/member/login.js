console.log('열림');
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
			}else{alert('[로그인실패]로그인 정보가 다릅니다.');}
		}
	})
	
}