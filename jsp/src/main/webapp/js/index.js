let productList = [ 
	{img :'1+1 메인사진.jpg', title :'캣잇 크리미 그레인프리 습식 튜브 간식' , price : 3000, discount : 0.67 , like : 54 , review : 99 },
	{img :'물개인형.jpeg', title :'펫긱 춤추는 물개 캣닢 자동 장난감' , price : 35000, discount : 0.60 , like : 55 , review : 104 },
	{img :'아이스크림.jpeg', title :'고양이 아이스크림 만들기 키트' , price : 1700, discount : 0.80 , like : 56 , review : 50 },
	{img :'카샤카샤.jpeg', title :'카샤카샤 병병-3날개' , price : 7000, discount : 0.80 , like : 57 , review : 51 },
	{img :'캣타워.jpg', title :'레츠펫 킹스 캣타워' , price : 125000, discount : 0.12 , like : 58 , review : 40 },
	{img :'지위픽.jpg', title :'지위픽 에어드라이 캣 고양이 사료(400g)' , price : 40000, discount : 0.1 , like : 59 , review : 104 }
]


product_print();

function product_print(){
	let html =``
	productList.forEach( ( o, i)=>{
		html += `<div class="item">								<!-- 제품 1개 -->
				<img src="img/${o.img}"> 				<!-- 제품 이미지 -->
				<div class="item_info">						<!-- 제품 정보 출력 구역 -->
					<div class="item_title">${o.title}</div>			<!-- 제품명 -->
					<div class="item_price"> ${o.price.toLocaleString()}원</div>			<!-- 원가 -->
					<div>
						<span class="item_sale">${(o.price - parseInt(o.price*o.discount)).toLocaleString()}원</span>			<!-- 판매가 -->
						<span class="item_discount">${parseInt(o.discount*100)}%</span>		<!-- 할인율 -->
						
					</div>
				</div>
				<div class="bottom_item">
					<div>
						<span class="badge rounded-pill text-bg-warning"> 주문폭주 </span>
						<span class="badge rounded-pill text-bg-danger"> 선택가능 </span>
					</div>
					<div class="item_review"> 찜 79 · 리뷰 1004</div>
					<!-- alt + 1 + 8 + 3 -->
				</div>
			</div>`
	})
	
	
	document.querySelector('.itembox').innerHTML =html;
}