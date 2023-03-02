//alert('js열림'); 확인용

//JS 함수
//function 함수명 ( 매개변수 ){ 실행코드 }
function Ex1(){
		
	let data = document.querySelector('.inputdata').value; // 호출
	//대입 : document.querySelector('.inputdata').value = '값'
	console.log(data);
	
	$.ajax({
		url : "/jspweb/ex1",		//통신할 서블릿 주소
		method : "post",					//HTTP 메소드
		data : {"data" : data},				//데이터 보내기
		success : function(result){			//데이터 받기
			console.log(result);
			Ex2();
		}			
	});
}

//
Ex2();	// 페이지 열리면 데이터 호출
 function Ex2(){
	 $.ajax({
		 url :"/jspweb/ex1",
		 method : "get",
		// data : {},
		 success : function(result){
			 console.log(result);
			 document.querySelector('.ex2box').innerHTML = result;
		 }		 
	 });
 }

//과제 1
//데이터 저장
function Q1(){
	let data = document.querySelector('.q1').value
	console.log(data);
	
	$.ajax({
		url : "/jspweb/q1",
		method : "post",
		data : {"data" : data},
		success : function(result){
			console.log(result);
			Q1_get();
		}
	});
}	
// 데이터 호출	
Q1_get();
function Q1_get(){
	$.ajax({
		url : "/jspweb/q1",
		method : "get",
		//data : 
		success : function(result){
			console.log(result);
			document.querySelector('.q1_get').innerHTML = result;
		}
	});	
}

 
 


	//document : 미리 만들어진 DOM객체
		//1. querySelector(식별자) : tag 1개 -> 변수/객체 저장
			//1. document.querySelector('.classname')
			//2. document.querySelector('#idname')
			//3. document.querySelector('tag[name='name']')
			
		//2. querySelectorAll(식별자)	: tag 여러개 -> 배열/리스트에 저장
			
		//3. querySelector.속성명
			//1. querySelector().value 		: input,select,textarea [ div , table x ]
			//2. querySelector().innerHTML 	: div,span,td 등
	
	
	//JS -> 서블릿 이동
		//0. $ : jqeury 표현식
		//1. ajax 메소드 사용 : $.ajax( );
		//2. ajax 매개변수[속성:객체형태] : { } --> $.ajax({ });
		//3. 속성
			//1. url : 통신할 경로 [서블릿[클래스]주소]
				/*
					url : "http://localhost:8080/jspweb/indextest"
					url : "http://192.168.17.136:8080/jspweb/indextest"
					url : "jspweb/indextest"			
				*/
			//2. method : heep 메소드방식
				/*
					get
					post
				 */
			//3. data : 통신 할때 데이터 보내기
				/*
					js객체 형태 : { 매개변수명 : 데이터 , 매개변수명 : 데이터 }
				*/
			//4. success : 통신 후 응답 데이터 받기
				/*
					success : function(매개변수){  }
					success : (매개변수) => {  }
				*/
		/* $.ajax({
			 url : "" , 
			 method : "" ,  
			 data :{이름:값},
			  success : function(result)
			 })
		*/