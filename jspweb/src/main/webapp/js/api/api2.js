//------------------------지도 생성 ------------------------
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
// document.getElementById == document.querySelector
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.3218778, 126.8308848), //지도의 중심좌표.
	level: 5 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

//------------------------ 마커 테스트 객체 ------------------------
/*var positions = [ 
    {
        title: '카카오', 
        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
    },
    {
        title: '생태연못', 
        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
    },
    {
        title: '텃밭', 
        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
    },
    {
        title: '근린공원',
        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
    }
];*/
//------------------------ 전기충전소 객체 ------------------------
//let positions = [];
//$.get("url",(r)=>{});
//$.post("url",(r)=>{});
//$.put("url",(r)=>{});
/*	$.ajax({
		url:"https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=d6G0imt5Vz21ZWQfaccWnoPsQ1pfEOSbMols03Bwa%2FgS88FT9gmyDyGD5hm5%2Fm2BFG%2FH%2BCDLkFzTLP3ZE1VTrg%3D%3D&returnType=json&numOfRows=100&pageNo=1&sidoName=%EA%B2%BD%EA%B8%B0&ver=1.0",
		method : "get",
		async : 'false' , // 비동기
		success : (r)=>{
			console.log(r); // 공공데이터 데이터 요청 결과
			
			r.data.forEach( (o)=>{ // 결과내 리스트 객체 반복문
				
				let info = {
					title : o.충전소명,
					latlng : new kakao.maps.LatLng(o['위도(WGS84)'], o['경도(WGS84)']) //필드명 특수문자 있는경우 :객체명['필드명']
				}
				console.log(info);
				positions.push( info ) //생성된 객체를 리스트[배열]에 담기
				console.log(positions);
				
			})//for e
			//------------------------ 마커 여러개 생성 ------------------------
			//js 변수선언 :  1.var  2.let  3.const
				// * var 변수명 중복 
		for (let i = 0; i < positions.length; i ++) {
    
    
   		 // 마커를 생성합니다
   		 var marker = new kakao.maps.Marker({
        	map: map, // 마커를 표시할 지도
        	position: positions[i].latlng, // 마커를 표시할 위치
        	title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        	image : markerImage // 마커 이미지 
   
   		 });
	    //------------------------ 마커 클릭 이벤트 생성 ------------------------
		// 마커에 클릭이벤트를 등록합니다
		kakao.maps.event.addListener(marker, 'click', function() {
	      
	    alert(  positions[i].title + ' :)');
			});
		}
	}
})*/

//------------------------ 마커 이미지 변경 ------------------------
var imageSrc = '/jspweb/img/%EC%A0%84%EA%B8%B0.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(44, 49), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(37.3218778, 126.8308848); // 마커가 표시될 위치입니다


//------------------------ 마커 1개 생성 ------------------------
// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() ,
    clickable: true, // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
    image: markerImage
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

//------------------------ 지도 클릭 이벤트 생성 ------------------------
// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;
    
});
//------------------------ 마커 클러스터 ------------------------
  // 마커 클러스터러를 생성합니다 
   var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 8 // 클러스터 할 최소 지도 레벨 
    });
    /*
    	.forEach( (o)=>{ } )	: 실행문에서 return이 없다.
    	.map( (o)=>{ } )		: 실행문에서 return하면 배열에 저장
    
    
    */

    
  $.get(
	 	"https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=d6G0imt5Vz21ZWQfaccWnoPsQ1pfEOSbMols03Bwa%2FgS88FT9gmyDyGD5hm5%2Fm2BFG%2FH%2BCDLkFzTLP3ZE1VTrg%3D%3D",
  		function(re) {
			  console.log(re);
        // 데이터에서 좌표 값을 가지고 마커를 표시합니다
        // 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
        	//let 린턴된값들 = map.( () =>return{ 마커생성 } )
        var markers = $(re.data).map(function(i, o) {
			
			//리턴
            let marker =  new kakao.maps.Marker({
                position : new kakao.maps.LatLng(o['위도(WGS84)'], o['경도(WGS84)']),
                image: markerImage
            });
              kakao.maps.event.addListener(marker, 'click', function() { 
		
	    	//모달 정보 담기
	    	document.querySelector('.modal_title').innerHTML = o.충전소명;
	    	document.querySelector('.modal_title').style.fontSize = '10px';
	    	document.querySelector('.modal_content').innerHTML = o;
	    	openmodal3();
			});
			//리턴해서 marker에 대입하기
			return marker;
        });

        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers); 
    });
  
