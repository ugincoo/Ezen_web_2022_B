
/* 공통 - DB */
// 등록된 카테고리 목록 
let categoryList = [ '프리미엄', '스페셜' , '와퍼', '올데이킹','치킨버거']
// 등록된 버거 목록 
let burgerList = [ 
	{ name : '기네스콰트로치즈와퍼' , price : 9500 , img : '버거1.png' , category : '프리미엄' } ,
	{ name : '몬스터X' , price : 8000 , img : '버거2.png' , category : '프리미엄' } ,
	{ name : '치킨킹팩1' , price : 13000 , img : '버거3.png' , category : '스페셜' } 
]
let cartList = [  ] // 카트 목록 
let orderList = [  ] // 주문 목록

category_print();
categoey_select( 0 ); // 기본값 : 프리미엄
product_print( 0 ); // 기본값 : 프리미엄

// 1. 카테고리 출력하는 함수 	// [ 1.js열렸을때]
function category_print(){
	// 1.HTML 구성
	let html = `<ul>`
	//*
	for( let i = 0 ; i< categoryList.length ; i++ ){
		html += `<li 
					class="categoryli" 
					onclick="categoey_select( ${i} )"
					> ${ categoryList[i] } </li>`
	} // for end 
	html+= `</ul>`
	// 2 해당 마크업에 HTML 출력 
	document.querySelector('.categorybox').innerHTML = html	
} // f e 

// 2. 카테고리 선택 함수 
function categoey_select( i ){ // i : 선택된 li의 인덱스
	// 1. 모든 li 가져와서 배열 저장 
	let categoryli = document.querySelectorAll( ".categoryli")
	// 2. 모든 li 배열 반복문 
	for( let j = 0 ; j<categoryli.length ; j++ ){
		if( j == i ){ // 만약에 li배열에서 내가 선택횐 li의 인덱스와 같으면
			categoryli[j].classList.add( 'categoryselect' ) ; // 해당 마크업의 class 식별자 추가 
		}else{ // 선택되지 않은 li
			categoryli[j].classList.remove( 'categoryselect'  );// 해당 마크업의 class 식별자 제거 
		}
	}
	// 3. 제품목록 렌더링 [ 화면 업데이트 ]
	product_print( i )
}
// 3. 제품출력 함수 // [ 1.js열렸을때[0:프리미엄] 2.카테고리 바뀌었때 ]
function product_print( index ){ 
	// 1. 기본 html 구성
	let html = '';
	// *
	for( let i = 0 ; i<burgerList.length ; i++ ){
		// i는 0번째 인덱스부터 마지막인덱스까지 버거 객체 가져온다.
		if( burgerList[i].category == categoryList[index] ){
			// i번째 버거객체의 카테고리와 선택된 카테고리와 같으면 
			html += `<div onclick="cardadd( ${i} )" class="product">
						<img src="img/${ burgerList[i].img }" width="100%" />
						<div class="productinfo">
							<div class="ptitle"> ${ burgerList[i].name } </div>
							<div class="pprice"> ${ burgerList[i].price.toLocaleString() } 원 </div>
						</div>
					</div>`
		}
	}
	// 2. 구성된 html를 마크업 대입
	document.querySelector('.productbox').innerHTML = html;
}
// 4. 선택한 제품을 카트에 담기 
function cardadd( i ){ // f s 
	cartList.push( burgerList[i] ) // 1. 선택한 i번째 버거의 객체를 cartlist에 추가 
	cart_print();  // 카트내 제품 화면 렌더링[새로고침]
} // f e 

// 5. 주문 취소 버튼 
function cancel(){
	alert('주문 취소합니다.'); cartList.splice(0); // 개수 생략시 모두 삭제 
	cart_print(); // 카트내 제품 화면 렌더링[새로고침]
} 

// 6. 주문 하기 버튼 
function order(){
	alert('주문 합니다.');
	// 1. 주문번호 만들기  [ // 마지막인덱스 : 배열명.length-1 ]
	let no = 0;
	if( orderList.length == 0 ){ no = 1;} // 1. 만약에 길이가 0 이면 [ 주문 하나도 없으면 주문번호 1 ]
	else{ no = orderList[ orderList.length-1 ].no+1 } // 2. 아니면 마지막인덱스 주문객체의 주문번호+1 를 다운 주문번호 사용 
	
	// 2. 카트배열 -> 새로운배열 [ 주문객체에 카트배열 대입시 카트배열 초기화시 주문객체내 카트배열도 초기화 = 메모리 동일하기 때문에 ]
	let for배열 = cartList.forEach( (o) => { console.log(o); return o; } )
	console.log( for배열 )
	console.log("--------------------------------------")
	let map배열 = cartList.map( (o) => {console.log(o); return o; } )
	console.log( map배열 )
	
	// 3. 총가격 만들기 
	let total = 0;
	for( let i = 0 ; i< map배열.length ; i++ ){ total += map배열[i].price }
	
	// 1. 주문
		// 1. order 객체 만들기 
		let order = { 
			no :  no ,
			itmes : map배열 ,			// 카트배열 ---> 새로운배열 
			time :  new Date() ,	// new Date() : 현재 날짜/시간 호출   
			state : true ,			// true : 일단 주문	// false : 주문완료  
			complete : 0 ,			// 아직 주문 완료 되기전 
			price : total			// cartlist 배열내 버거객체들의 총금액 합계 
		}
		// 2. order 객체 배열에 저장 
		orderList.push( order  ); console.log(  orderList )
	// 2. 주문완료 후 
	cartList.splice(0)
	cart_print();
}

// 7. 카트내 버거 출력 [ 1. 제품 클릭할때마다 , 2.취소/주문 ]
function cart_print(){
	// 2. 버거 개수 카운트
	document.querySelector('.pcount').innerHTML = cartList.length
	// 3. 버거 총 금액 
	let total = 0;
	for( let j = 0 ; j<cartList.length ; j++ ){ total += cartList[j].price } 
	document.querySelector('.ptotal').innerHTML = total.toLocaleString();
	// 4.
	let html = ''	// 1. 기본 html 구성 
	for( let j = 0 ; j<cartList.length ; j++ ){
		html += `<div class="item">
					<div class="ititle"> ${ cartList[j].name } </div>
					<div class="iprice"> ${ cartList[j].price.toLocaleString() }원</div>
				</div>`
	}
	document.querySelector('.cartbottom').innerHTML = html; // 2. 구성된 html 마크업에 대입 
}

/*
	for( let 반복변수 of 배열명 ) {  실행문; }		: 배열내 모든 요소를 하나씩 반복변수에 대입후 실행문;
	
	배열명.forEach( (반복변수) -> { 실행문; }  )		: 배열내 모든 요소를 하나씩 반복변수에 대입후 실행문;
	
	배열명.map( (반복변수) -> { 실행문; retrun 값; } )	: 배열내 모든 요소를 하나씩 반복변수에 대입후 실행문;
						* retrun 값을 새로운 배열 반환

	- 기존 배열 메모리를 새로운 배열메모리 할당 방법
		1. 
			let 새로운배열  = cartList.map( (o) => {console.log(o); return o; } )

		2. 
			let 새로운배열 = [ ]
			for( let i = 0 ; i<cartList.length ; i++ ){ 새로운배열.push( cartList[i] ) }

*/
//---------------------------- 포스기 함수 -----------------------------------
function pos_btn(){
	
	let b_name = document.querySelector('.b_name').value
	let b_cate = document.querySelector('.b_cate').value
	let b_price = parseInt( document.querySelector('.b_price').value)
	let b_img = document.querySelector('.b_img').value	
	
	check = true; // 
	// 이름 중복 확인
		for(let i = 0 ; i < burgerList.length; i++){
			if(burgerList[i].name == b_name){
				alert('이미 등록된 이름입니다.') ; return false;
			}else if (categoryList.indexOf(b_cate) < 0){
				alert('카테고리를 확인 하세요.') ; return false;
			}
		}
		
		
		if(isNaN(b_price)){
		alert('숫자로 입력해주세요') ; return false;
		}
		
	let newInfo = { //새로운 인포애 저장
		name : b_name, category : b_cate,
		price : b_price, img : b_img
	}
	
	if(check){burgerList.push(newInfo)};
	burgerPrint()
	category_print();
	categoey_select( 0 ); // 기본값 : 프리미엄
	product_print( 0 ); // 기본값 : 프리미엄

}

function bDelete(i){ // 삭제 함수
	burgerList.splice(i,1);
	burgerPrint();
}

function bEdit(i){ //수정 함수
	let Edit = prompt('수정 가격을 입력해주세요')
		burgerList[i].price = Edit //속성값수정
		alert('수정하였습니다.'); 
		burgerPrint();
}

//등록,수정,삭제시 출력
 function burgerPrint(){ 
	 let html_b = `<tr>
	 					<th>번호</th>
	 					<th>버거이름</th>
	 					<th>카테고리</th>
	 					<th>가격</th>
	 					<th>이미지</th>
	 					<th>비고</th>
	 				</tr>`
	 for (let i = 0 ; i < burgerList.length ; i++){
		 //버거 이미지 어떻게 넣지???
		 html_b += `<tr>
		 				<td>${i+1}</td>	
		 				<td>${burgerList[i].name}</td>
		 				<td>${burgerList[i].category}</td>
		 				<td>${burgerList[i].price}</td>
		 				<td><img src="img/${burgerList[i].img}" width="30%" height=30%"</td>
		 				<td>
		 					<button onclick="bEdit(${i})">가격수정</button>
		 					<button onclick="bDelete(${i})">삭제</button>
		 				</td>			
		 
		 			</tr>`
	 }
	 	document.querySelector('.b_list').innerHTML = html_b
	  }

function burgerOrder(){
	let order_b = `<tr>
	 					<th>주문번호</th> <th>버거이름</th>
	 					<th>상태</th>		<th>비고</th>
	 				</tr>`
	 				
	for(let i = 0; i < orderList.length; i++){//화살표 함수 맞나... 더 알아보고 수정하자..ㅜ
		for(let u = 0 ; u < itemes.length; u++){
			let ready = (i) => {if (orderList[i].state == true){return '주문요청'}else(order[i].state == false){return '주문완료'}} 
			let comlete = (i) => {if (orderList[i].complete = 1){return '주문완료'}}
		}
		order_b += `<tr>
	 					<td>${orderList[i].no}</td> <td>${orderList[i].items}</td>
	 					<td>${ready[i]}</td>		<td><button>주문완료</button></td>
	 				</tr>`
	} 	
	document.querySelector('.orderList').innerHTML = order_b
	burgerPrint()		
}



