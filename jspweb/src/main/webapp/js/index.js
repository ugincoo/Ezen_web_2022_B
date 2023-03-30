console.log('열림');
/*//제품출력
$.ajax({
	url : "/jspweb/product/info",
	success : (r) => {
		console.log(r);
		}
	})
*/

// 전역변수
let productlist = null;	//productlist()의 ajax로부터 요청된 결과를 담는곳
let index = 0;	//현재 보고 있는 제품의 제품 인덱스
let chatmno = 0;	// 현재 채팅하고 있는 상대방의 mno

// 1. 제품목록 html 출력
function getproductlistprint(){

       let html ='';
       productlist.forEach( (p,i)=>{
		    html +=`			<!-- 제품 1개  -->
								<div onclick="productprint(${i})" class="productbox">
									<div class="pimgbox">
										<img src="/jspweb/product/pimg/${p.pimglist[0] }" >
									</div>
									<div class="pcontentbox">
									<div class="pname"> ${p.pname}</div>
									<div class="pprice">${p.pprice.toLocaleString()}원 </div>
									<div class="pdate"> ${p.pdate} </div>
									<div class="petc">
										<i class="far fa-eye"></i>  ${p.pview}
										<i class="far fa-thumbs-up"></i>  2
										<i class="far fa-comment-dots"></i> 10
									</div>
				</div>
			</div>	`
	   } )
	 document.querySelector('.productListbox').innerHTML = html;
  
}

// 2. 제품개별조회
function productprint( i ){
let p = productlist[i];
//이미지 슬라이드에 대입할 html 구성
let imgHTML = ``;
p.pimglist.forEach( (img,i)=>{
	if(i == 0 ){//첫 이미지에면 active 클래스 적용
		imgHTML +=`<div class="carousel-item active">
				 <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
				</div>`
	}
	imgHTML +=`<div class="carousel-item">
				 <img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
				</div>`
} )
	 let html = ``;
	    
		html+=`<div class="pviewbox">
				<div class="pviewinfo">
	
					<div class="mimgbox">
						<img src="/jspweb/member/pimg/${p.mimg == null ? '기본.jpg' : p.pimg }" class="hpimg">
						<span class="mid">${p.mid}</span>
					</div>
					<div>
						<button onclick="getproductlistprint()" class="pbadge" type="button"> 뒤로가기</button>
					</div>
					
				</div>
				<!-- 이미지캐러셀 : 부트스트랩 -->
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-inner">
				    ${imgHTML}
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
			</div>
			<!-- 제품상세내용물 -->
			<div class="pdate"> ${p.pdate}</div>
			<div class="pname"> ${p.pname} </div>
			<div class="pcomment"> ${p.pcomment} </div>
			<div class="pstate "> <span>${p.pstate == 1 ?'판매중' : p.psate == 2 ?'거래중' : '판매완료'}</span>  </div>
			<div class="pprice"> ${p.pprice.toLocaleString()}원 </div>
			<div class="petc">
				<i class="far fa-eye"></i> ${p.pview}
				<i class="far fa-thumbs-up"></i>  2
				<i class="far fa-comment-dots"></i> 10
			</div>
			<div class="pviewbtnbox"> 
				<button onclick="setplike(${p.pno})"  class=" pbtn plikebtn" type="button"><i class="far fa-heart"></i> </button>
				<button onclick="chatprint(${i})" class="pbtn" type="button"> 대화하기 </button>
			</div>
		</div>
		` 
				
			    document.querySelector('.productListbox').innerHTML = html;
			   	getplike(p.pno);
	
}
// 9. 채팅목록페이지
function chatlistprint(i){
	let p = productlist[i];
	
	let html=``;
	$.ajax({
		url :"/jspweb/product/chat",
		method : "get",
		data : {"pno":p.pno,"chatmno":0 },
		async : false, /* 동기식 */
		success : (r)=>{
			console.log(r);
			let printfrommno =[]	// 출력된 mno
			r.forEach( (o)=> {
				if(!printfrommno.includes(o.frommno)){//includes : 같은값 포함되어 있는지 찾아주는 함수
					printfrommno.push(o.frommno); //구매자 번호 저장 후  // 구매자별 한개씩만 출력

				html +=`
				<div onclick="chatinfoprint(${i},${o.frommno})" class="chatlist">
					<div class="frommid"><img src="/jspweb/member/pimg/${o.frommimg == null ? '기본.jpg' : o.frommimg}" class="hpimg">  </div>
					<div class="frominfo">
						<div class="fromndate"> ${o.ndate}  </div>
						<div class="frommid"> ${o.frommid} </div>
						<div class="fromcontent"> ${o.ncontent} </div>
					</div>
			</div>`
					}
			} )// forEach e
			//구매자 번호가 없으면
			if(printfrommno.length == 0){
				html+='채팅이 없습니다.';
			}
			
		}
	})
	document.querySelector('.productListbox').innerHTML=html;
	
}



//10.채팅방 내용물 요청해서 html에 출력
function getcontent(){
	let chathtml ='';
	let pno = productlist[index].pno;	//현재 보고있는 제품의 인덱스 
	$.ajax({
		url :"/jspweb/product/chat",
		method : "get",
		data : {"pno":pno,"chatmno":chatmno},
		async : false, /* 동기식 */
		success : (r)=>{
			console.log(r);

			r.forEach( (o)=>{
				if(o.frommno == memberInfo.mno ){//현재 로그인된 사람과 보낸사람이 일치하면 
					chathtml += `<div class=" sendbox">${o.ncontent} </div>`
				}else if(o.frommno == chatmno ){//메시지 보낸 사람과 채팅 대상자가 일치하면
					chathtml += `<div class=" receivebox">${o.ncontent} </div>`
				}
			} )
		}
	})
		document.querySelector('.chatcontent').innerHTML = chathtml;
}
//11. 채팅방 html요청
function chatinfoprint(i,tomno){
	console.log(tomno+'에게  메세지 전송 페이지');
	index = i ; 
	chatmno = tomno;
	
	let p = productlist[index];
	
	let html=`
			<div class="chatbox">
				<div class="pviewbox">
					<div class="pviewinfo">
						<div>
							<img src="/jspweb/product/pimg/${p.pimglist[0]}" class="hpimg">
							<span> ${p.pname}</span>
						</div>
						<div class="mimgbox">
							<button onclick="getproductlistprint()" class="pbadge" type="button"> 뒤로가기</button>
						</div>
				 	</div>
				 
					 <div class="chatcontent">
				 		//10번[getcontent()] 함수에서 대입 할 예정
					 </div>	
				 
				 	<div class="chatbtn">
				 		<textarea class="ncontentinput" rows="" cols=""></textarea>
				 		<button onclick="sendchat(${p.pno})" type="button"> 전송 </button>
					 </div>	
				 </div>
			 </div>
		 `
	document.querySelector('.productListbox').innerHTML = html;
	getcontent();
}

// 3. 채팅 페이지 [로그인검사, 등록자 검사]
function chatprint(i){
	let p = productlist[i];
	
	if(memberInfo.mid == null){
		alert('회원기능입니다.');
		return;
	}

	//등록한 회원이면  [판매자]
	if(memberInfo.mno == p.mno){
		console.log('본인이 등록한 제품입니다.');
		chatlistprint(i); //채팅목록 보냄
		return;
	}
	//만약에 등록한 회원이 아니면 [구매자] : frommno 필요없음 -> 판매자 <--> p.mno == frommno
	chatinfoprint(i , p.mno);
}
//제품채팅 전송
function sendchat(pno){
	//console.log(pno);
	let ncontent = document.querySelector('.ncontentinput').value;
	
	$.ajax({
		url :"/jspweb/product/chat",
		method : "post",
		data : {"pno":pno ,"tomno":chatmno, "ncontent" : ncontent},
		success : (r)=>{
			console.log(r);
			if(r == 'true'){
				document.querySelector('.ncontentinput').value = '';
				getcontent();	//채팅창 목록 새로고침..
			}
		}
	})
	
}




//----------------------- 지도생성 -----------------------
 var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.321917560942296,  126.83083441420393), // 지도의 중심좌표 
        level : 7 // 지도의 확대 레벨 
    });
 //------------------------ 마커 이미지 변경 ------------------------
var imageSrc = '/jspweb/product/pimg/곰.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(54, 59), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.3218778, 126.8308848); // 마커가 표시될 위치입니다

   
//----------------------- 지도 컨트롤 생성 -----------------------  
// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

//-------------------------- 마커 클러스터러 --------------------------   
 // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 5 // 클러스터 할 최소 지도 레벨 
       
    });
 
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    
    
//1. 제품목록 호출 [ 1. 현재 보이는 지도 좌표 내 포함된 제품만 ]   
function  fproductlist(동, 서, 남, 북){

	clusterer.clear();	//클러스터 비우기
	$.ajax({
		url : "/jspweb/product/info",
		method : "get",
		async : false,
		data : {"동":동 , "서":서 ,"남":남 , "북":북},
		success : (r)=>{
		
			console.log(r)
	       
	       //$(r).map( (인덱스,반복객체명) =>{ })			실행문에서 return 값을 배열에 대입 
	       //r.map( (인덱스,반복객체명) =>{ })			실행문에서 return 값을 배열에 대입 
	       //vs 
	       //forEach( (반복객체명,인덱스)=> { } ) 	실행문에서 return X
	       
	      //----------------------- 사이드바 작업 -----------------------  
	      productlist = r;	//제품목록 결과를 전역변수에 담아주기
	      getproductlistprint();
	      //----------------------- 마커 작업 -----------------------  
	        var markers = $(r).map( (i,p)=> {
				console.log(p)
				
	            let marker =  new kakao.maps.Marker({
	                position : new kakao.maps.LatLng(p.plat, p.plng),
	                  image: markerImage
	            });
	            // 마커에 클릭이벤트를 등록합니다
				kakao.maps.event.addListener(marker, 'click', function() {
					productprint( i )
				});// 마커이벤트 end
	            return marker;
	      	  });// map end
	
	        // 클러스터러에 마커들을 추가합니다
	        clusterer.addMarkers(markers);
	       } //success end
    });	// ajax end
}// function end
//2. 현재 지도의 좌표얻기
get동서남북();
function get동서남북(){
	
    // 지도의 현재 영역을 얻어옵니다 
    var bounds = map.getBounds();   
    // 영역의 남서쪽 좌표를 얻어옵니다
    var swLatLng = bounds.getSouthWest();     
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast();
    
    let 남 = swLatLng.getLat();
    let 서 = swLatLng.getLng();
    let 북 = neLatLng.getLat();
    let 동 = neLatLng.getLng();

	fproductlist(동, 서, 남, 북);
    
	/*  var message ='지도의 남서쪽 좌표는 ' + swLatLng.getLat() + ', ' + swLatLng.getLng() + ' 이고 <br>';
   	 	message += '북동쪽 좌표는 ' + neLatLng.getLat() + ', ' + neLatLng.getLng() + ' 입니다';
    
    	console.log(message);*/	
}	
   
//----------------------- 지도 중심좌표 이동 이벤트 -----------------------  
							//(객체, 온클릭(이벤트), function)  
kakao.maps.event.addListener( map, 'dragend', function() {
	get동서남북();
});


//찜하기 버튼 눌렀을때 [ 첫 클릭시 찜하기 다음 클릭시 찜하기 취소 다음 클릭시 찜하기 ]
function setplike(pno){
	
	if(memberInfo.mid == null){
		alert('회원만 가능합니다. 로그인 후 이용해주세요');return;
	}
	
	$.ajax({
		url : "/jspweb/product/like",
		method : "post",
		data:{"pno":pno},	
		success : (r)=>{
			if(r == 'true'){
				alert('찜하기!');
				document.querySelector('.plikebtn').innerHTML='♥';
			}else{
				alert('찜취소');
				document.querySelector('.plikebtn').innerHTML='♡';
			}
		}
	})
	
	
/*	$.post({
		 "/jspweb/product/like,{"pno":pno},(r_)=>{}"
	});*/
	/*$.ajax({
		url : "/jspweb/product/like?pno="+pno,
		success : (r)=>{
			
		}
	})*/
}

//현재 회원의 찜하기 상태 호츌
function getplike(pno){
	
	if(memberInfo.mid == null){
		document.querySelector('.plikebtn').innerHTML='♡';
	}
	
	$.ajax({
		url : "/jspweb/product/like",
		method : "get",
		async :'false',
		data:{"pno":pno},	
		success : (r)=>{
			if(r == 'true'){
				document.querySelector('.plikebtn').innerHTML='♥';
			}else{
				document.querySelector('.plikebtn').innerHTML='♡';
			}
		}
	})
}