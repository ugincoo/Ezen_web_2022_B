/*//안산시 약국 공공데이터
gethos();
function gethos(){
	$.ajax({
		url : "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=256&serviceKey=d6G0imt5Vz21ZWQfaccWnoPsQ1pfEOSbMols03Bwa%2FgS88FT9gmyDyGD5hm5%2Fm2BFG%2FH%2BCDLkFzTLP3ZE1VTrg%3D%3D",	
		method : "get",
		success : (re)=>{
			console.log(re);
		}
	})
}*/

//------------------------지도 생성 ------------------------
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
// document.getElementById == document.querySelector
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.3218778, 126.8308848), //지도의 중심좌표.
	level: 5 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

//------------------------지도 크기 컨트롤 생성 [O] ------------------------

// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

//------------------------ 주소-좌표 변환  ------------------------

	// 주소-좌표 변환 객체를 생성합니다

function getgeocoder(){
	$.ajax({
		url : "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=150&serviceKey=d6G0imt5Vz21ZWQfaccWnoPsQ1pfEOSbMols03Bwa%2FgS88FT9gmyDyGD5hm5%2Fm2BFG%2FH%2BCDLkFzTLP3ZE1VTrg%3D%3D",	
		async : 'false',
		method : "get",
		success : (re)=>{
			console.log(re);
			re.data.forEach( (o)=>{
							// 주소로 좌표를 검색합니다			
					
			geocoder.addressSearch(o.주소, function(result, status) {
			
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
			
			        let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
					let info = {title : o.약국명 ,latlng: new kakao.maps.LatLng(result[0].y, result[0].x) }
					console.log(info);
				

			        // 결과값으로 받은 위치를 마커로 표시합니다
			        let marker = new kakao.maps.Marker({
			            map: map,
			            position: coords,
			            image: markerImage
			        });
			       
			        //클릭 이벤트
					kakao.maps.event.addListener(marker, 'click', function() {
      					// 마커 위에 인포윈도우를 표시합니다
      					alert(o.약국명+"입니다.");
					});
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        marker.setMap(map);
		   			 } 

				});   


			})
			
		}
	})
	
}

//------------------------마커 이미지 [O]  ------------------------
var imageSrc = '/jspweb/img/약국.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(34, 39), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.3218778, 126.8308848); // 마커가 표시될 위치입니다

//------------------------마커 여러개 [O]   ------------------------   
	let geocoder = new kakao.maps.services.Geocoder();
    // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 10 // 클러스터 할 최소 지도 레벨 
    });

 	
    // 데이터를 가져오기 위해 jQuery를 사용합니다
    // 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    $.get(
		"https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=150&serviceKey=d6G0imt5Vz21ZWQfaccWnoPsQ1pfEOSbMols03Bwa%2FgS88FT9gmyDyGD5hm5%2Fm2BFG%2FH%2BCDLkFzTLP3ZE1VTrg%3D%3D",
		 (re)=> {
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        var markers = $(re.data).map(function(i,o) {
			
			geocoder.addressSearch(o.주소, function(result, status) {
			
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
			
			        let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
					let info = {title : o.약국명 ,latlng: new kakao.maps.LatLng(result[0].y, result[0].x) }
					console.log(info);
				

			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            position: coords,
			            image: markerImage
			        });
			       
			        //클릭 이벤트
					kakao.maps.event.addListener(marker, 'click', function() {
      					// 마커 위에 인포윈도우를 표시합니다
      					alert(o.약국명+"입니다.");
					});
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			       marker.setMap(map);
			       
		   			 } 
					 
					return marker;  
				});   
				
            
        });
		
        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);
       console.log(markers);
    });

    
//------------------------마커 생성 ------------------------
var markerPosition  = new kakao.maps.LatLng(37.3218778, 126.8308848); 
// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition,
    clickable: true,
    image: markerImage // 마커이미지 설정 
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);