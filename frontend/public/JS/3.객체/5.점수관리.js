//console.log('JS')

let studentArray = [ ] //학생들의 점수 객체를 여러개 저장하는 배열

//1.JS 열렸을때
let addbtn = document.querySelector('.addbtn')
//2. 해당 버튼에 클릭 이벤트
addbtn.addEventListener('click', () => { //html onclick이랑 같은 기능

	/* 입력받은 데이터 여러개 한번에 가져오기
	let inputArray = document.querySelectorAll('input')*/
	
	//1. 입력받은 데이터 하나씩 가져오기
		//*input 숫자를 입력해도 value는 무조건 문자열 가져온다. 형변환 필요 
	let info ={
		name : document.querySelector('.name').value,
		kor : parseInt(document.querySelector('.kor').value),
		eng : parseInt(document.querySelector('.eng').value),
		mat : parseInt(document.querySelector('.mat').value)
	}
		//console.log(info)
		
	//2. 유효성 검사 [데이터 체크]
	let check = true;	// 유효성검사 상태 저장하는 변수 [ 아래 4중 하나라도 충족하면 저장 실패 ]
		//1. 이름 중복 찾기
	/* studentArray.forEach( (obj) => {
		 if(obj.name == info.name){
			 alert('현재 등록 된 학생명입니다.'); return;} // for Each */
	for( let i = 0 ; i< studentArray.length ; i++ ){
		if( studentArray[i].name == info.name ){
			alert('이미 등록된 이름입니다.'); check = false;
		} // if end 
	}//for end		
		//2. 점수 0~100 사이만 입력
	if( (info.kor <0 || info.kor>100) ||
		(info.eng <0 || info.eng>100) ||
		(info.mat <0 || info.mat>100) ){
		alert('입력 할 수 없는 점수범위 입니다.[0~100점 사이 입력]') ; check = false;
	}	
		//3.이름이 3~5 사이만 입력
	if(info.name.length<=2 || info.name.length>=6){
		alert('이름을 3~5자로 입력해주시기 바랍니다.') ; check = false;
	}
		//4. 숫자가 아닌경우 [isNaN() : 숫자 체크 [문자 True or 숫자 False]]
	if(isNaN(info.kor) ||  isNaN(info.eng) || isNaN(info.mat) ){
		alert('숫자형식으로 입력 해주세요') ; check = false;
	}

	//3. 저장 [ 위 유효성 검사에서 하나라도 충족하지 않았을때 ]
	if( check ){ studentArray.push( info ); alert('학생 점수를 등록 했습니다.') }
	출력()
})
출력()
function 출력(){
	let listtable = document.querySelector('.listtable').value
	
	list=`<tr>
				<th>번호</th>	<th>이름</th>	<th>국어</th>
				<th>영어</th>	<th>수학</th>	<th>총점</th>
				<th>평균</th>	<th>순위</th>	<th>비고</th>
		  </tr>`
	/*for(let i =0 ; i <studentArray.length ; i++){
		list += `<tr>
				<td>${i+1}</td>
				<td>${studentArray[i].name}</td>
				<td>${studentArray[i].kor}</td>
				<td>${studentArray[i].eng}</td>
				<td>${studentArray[i].mat}</td>
				<td>${studentArray[i].kor+studentArray[i].eng+studentArray[i].mat}</td>
				<td>${parseInt(studentArray[i].kor+studentArray[i].eng+studentArray[i].mat)/3}</td>				
				<td>순위</td>
				<td>비고</td>
		  </tr>`
		 */ 
	studentArray.forEach((o,i)=> {
		
		//1.총점
		let total = o.kor+o.eng+o.mat;
		//2.순	위
		let rank = 1;
		studentArray.forEach((o2)=>{
			//1.비교 할 총점
			let total2 = o2.kor + o2.eng + o2.mat;
			//2. 만약에 총점이 비교 할 총점보다 작으면 순위 하락
			if(total < total2){rank++;}
		})
		
		list +=`<tr>
				<td>${i+1}</td>			<td>${o.name}</td>	<td>${o.kor}</td>
				<td>${o.eng}</td>		<td>${o.mat}</td>	<td>${total}</td>
				<td>${parseInt(total/3)}</td>	<td>${rank}</td>	
				<td> <button onclick="삭제(${i})">삭제</button> 
					 <button onclick="onUpdate(${i})">수정</button>
				</td>
		  </tr>`
	})	  
	  
	document.querySelector('.listtable').innerHTML = list
}
function 삭제(i){
	studentArray.splice(i,1); //선택한 i번째 인텍스 객체 삭제
	출력()	// 삭제 후 새로고침/업데이트
}
//4. 수정 버튼을 눌렀을때[수정 할 인텍스 필요!!]
let upindex = -1; //-1 : 기본값 인덱스없다//수정 할 인덱스 // 여러개 { }에서 동일한 변수 사용 하려고 
function onUpdate(i){
	upindex = i // 내가 선택한 i번째 인덱스 
	//1. 수정 페이지 보여주기
	document.querySelector('.updatebox').style.display = 'block'
	//2. 기존의 i번쨰 객체 데이터를 대입
	document.querySelector('.upname').value = studentArray[upindex].name
	document.querySelector('.upkor').value = studentArray[upindex].kor
	document.querySelector('.upeng').value = studentArray[upindex].eng
	document.querySelector('.upmat').value = studentArray[upindex].mat
}	
//5. 점수수정 버튼을 클릭했을때
	let updatebtn = document.querySelector('.updatebtn')	
	updatebtn.addEventListener('click', ()=>{
		
		//1. 수정된 데이터 가져오기 //2. 해당 객체의 속성 값 변경
		studentArray[upindex].kor=parseInt(document.querySelector('.upkor').value)
		studentArray[upindex].eng=parseInt(document.querySelector('.upeng').value)
		studentArray[upindex].mat=parseInt(document.querySelector('.upmat').value)
		
		//수정페이지 숨기기
		document.querySelector('.updatebox').style.display = 'none'
		
		출력(); //수정 후 업데이트
	})
	
	
	
	
	
	
	
	

