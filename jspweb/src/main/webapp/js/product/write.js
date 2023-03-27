console.log('열림');

if(memberInfo.mid == null){
	alert('로그인 후 이용 가능 합니다.');
	location.href="/jspweb/member/login.jsp";
}


//전역변수
let plat = 0;
let plng = 0;

//제품등록함수
function onwrite(){
	
	//1. 폼객체
	let writeForm = document.querySelectorAll('.writeForm')[0];
	
	let writeFormData = new FormData(writeForm);
	
	writeFormData.set("plat",plat);
	writeFormData.set("plng",plng);
	
	if(plat == 0 || plng == 0){alert('등록 할 위치를 선택해주세요'); return;}
	if(fileList.length < 1 ){
		alert('하나이상의 이미지를 등록해주세요');
		return;
	}
	
	// 폼에 드래그 된 첨부파일 등록
	fileList.forEach((f)=>{
		//배열에 존재하는 파일들을 하나씩 폼에 등록
		writeFormData.append("fileList",f);
	})

	
	
	
	$.ajax({
		url : "/jspweb/product/info",
		method : "post",
		data : writeFormData,
		contentType : false,
		processData : false,
		success : (r) => {
			console.log('통신');	console.log(r); 
			if(r =='true'){
				alert('제품 등록 되었습니다.');
				location.href="/jspweb/index.jsp"
			}else{
				alert('제품등록 실패하였습니다.')
			}
		}
	})
	
}







//-------------------------- 카카오지도 표시 div --------------------------
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.321917560942296,  126.83083441420393), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//-------------------------- 클릭 이벤트 --------------------------
// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {          
    var latlng = mouseEvent.latLng;     // 클릭한 위도, 경도 정보를 가져옵니다     
    marker.setPosition(latlng);   	 // 마커 위치를 클릭한 위치로 옮깁니다    
	plat = latlng.getLat();
	console.log("위도 : " +latlng.getLat());
    plng = latlng.getLng();
 	console.log("경도 : " +latlng.getLng());
});
//-------------------------- 드로그앤드랍 구현 --------------------------
//1. 드로그앤드랍 구역 객체 호출
let fileDrop = document.querySelector('.fileDrop');
//해당 구역에 드래그된 파일들을 저장하는 리스트/배열
let fileList = [];
//2.이벤트 추가
	//1. 
fileDrop.addEventListener("dragenter",(e)=>{
	console.log('드래그요소가 해당 구역에 닿았을때');
	e.preventDefault();
})
fileDrop.addEventListener('dragover',(e)=>{
	console.log('드래그요소가 해당 구역에 위치하고 있을때');
	e.preventDefault();
	fileDrop.style.backgroundColor = "#e8e8e8";
})
fileDrop.addEventListener('dragleave',(e)=>{
	console.log('드래그요소가 해당 구역에서 나갔을때');
	e.preventDefault();
	fileDrop.style.backgroundColor = "#ffffff";
})
fileDrop.addEventListener('drop',(e)=>{
	console.log('드래그요소가 해당 구역에 드랍 됐을때');
	e.preventDefault();
	//1. 드랍된 파일 호출하여 가져오기
	let files = e.dataTransfer.files;
	console.log(files);
	for(let i =0 ;i <files.length;i++){
		if(files[i] !=null && files[i] != undefined){	//비어있지않고 정의되어 있으면
			fileList.push(files[i]);
		}
	printfiles();
	fileDrop.style.backgroundColor = "#ffffff";

	}
})
//3. 해당구역에 드롭된 파일 출력
function printfiles(){
	let html=``;
	fileList.forEach( (f,i)=>{
		let fname=f.name;
		console.log(f.name);	//파일명 호출
		let fsize = (f.size/1024).toFixed(2);	//파일 용량[바이트]
		//toFixed() :소수점 수 자르기 
		console.log(f.size);
		
		html += `
				<div>
					<span>${fname} </span>
					<span>${fsize}KB </span>
					<span><button type="button" onclick="filedelete(${i})"> 삭제 </button</span>
				</div>	
		`
	} )
	fileDrop.innerHTML = html;
}

//4. 드앤드 특정 파일 삭제 
function filedelete(i){
	fileList.splice(i,1);
	printfiles();
}