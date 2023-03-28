console.log('열림');
/*//제품출력
$.ajax({
	url : "/jspweb/product/info",
	success : (r) => {
		console.log(r);
		}
	})
*/

let productlist = null;

function getproductlistprint(){

       let html ='';
       productlist.forEach( (p,i)=>{
		    html +=`			<!-- 제품 1개  -->
								<div onclck="productprint(${i})" class="productbox">
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
//제품개별조회
function productprint( i ){
let p = productlist[i];
	 let html = `<button onclick="getproductlistprint()"> <- </button><h3> 제품 상세페이지 </h3>`;
	     			 html += `
					  	 <div>
					   		<span> ${p.pname} </span>
					   		<span> ${p.pcomment}  </span>
					   		<span> ${p.pprice}  </span>
					   		<span> ${p.pstate}  </span>
					   		<span> ${p.pview}  </span>
					   		<span> ${p.pdate}  </span>
					   		<div><button class="plikebtn" onclick="setplike(${p.pno})" type="button"> </button></div>
					   </div>
					   `
					 
				
			    document.querySelector('.productListbox').innerHTML = html;
			   	getplike(p.pno);
	
}

//----------------------- 지도생성 -----------------------
 var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.321917560942296,  126.83083441420393), // 지도의 중심좌표 
        level : 7 // 지도의 확대 레벨 
    });
    
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
	                position : new kakao.maps.LatLng(p.plat, p.plng)
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