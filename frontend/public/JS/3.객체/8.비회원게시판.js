console.log('JS')

//*함수 밖에 만드는 이유 : 전역변수 :  모든 함수에서 동일한 메모리 사용 
let contents = [ ]
	//이벤트함수
		//1. <button type="button" onclick="onwrite()"> 글 등록 </button>
			//function onwrite(){}
		//2.<button type="button" class="onwritebtn"> 글 등록 </button>
			//document.querySelector('.onwritebtn').addEventListener('click',(e) => )

//1. 글 등록 함수
function onwrite(){
	//console.log('2.onwrite 함수열림')
	
	//1.입력받은4개 데이터를 하나의 객체 선언
	let info ={//1. let 객체명(아무거나) = {속성명:데이터,속성명:데이터,속성명:데이터}
		bwriter : document.querySelector('.bwriter').value,
		bpassword : document.querySelector('.bpassword').value,
		btitle : document.querySelector('.btitle').value,
		bcontent : document.querySelector('.bcontent').value
	}
	console.log(info)
		
	//2. 유효성검사 //객체명.속성명
		//1. 입력받은 데이터 길이 검사
	if(info.bwriter.length <=0 || info.bpassword.length <= 0 ||
		info.btitle.length <= 0 || info.bcontent.length <= 0){
		alert('작성이 안된 구역이 있습니다. 작성해주세요.')
		return; // 함수종료 -> 해당 함수에서 아래로 진행불가능
	}
	
	//3. 배열에 저장 *추후 :  백엔드에게 통신하여 데이터 전달 [ 백엔드 : java,db ]
	contents.push(info)
	alert('글 등록 성공')
	console.log(contents)
	//4. input 초기화
	document.querySelector('.bwriter').value =''
	document.querySelector('.bpassword').value =''
	document.querySelector('.btitle').value =''
	document.querySelector('.bcontent').value =''	
}



