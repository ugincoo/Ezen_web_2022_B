console.log('열림');

/* AJAX를 이용한 데이토포털[json]의 데이터 가져오기 */
//실시간 미세먼지 현황
getapi2();
function getapi2(){
	$.ajax({
		url:"https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=d6G0imt5Vz21ZWQfaccWnoPsQ1pfEOSbMols03Bwa%2FgS88FT9gmyDyGD5hm5%2Fm2BFG%2FH%2BCDLkFzTLP3ZE1VTrg%3D%3D&returnType=json&numOfRows=100&pageNo=1&sidoName=%EA%B2%BD%EA%B8%B0&ver=1.0",
		method : "get",
		success : (r)=>{
			console.log(r);
			console.log(r.response.body.items);
		}
	})
	
}



//전기차 충전소 현황 (안산)
getapi1();
function getapi1(){
$.ajax({
	//url : "신청한 공공데이터포털 url"
	url : "https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=d6G0imt5Vz21ZWQfaccWnoPsQ1pfEOSbMols03Bwa%2FgS88FT9gmyDyGD5hm5%2Fm2BFG%2FH%2BCDLkFzTLP3ZE1VTrg%3D%3D",
	method : "get",
	success : (r) =>{
		console.log(r);
		document.querySelector('.totalcount').innerHTML ='전기차 충전소 개수 : ${r.totalCount}';
		let html = `
				<tr>
					<th width="10%"> 시군명 </th>
					<th width="15%"> 도로명주소 </th>
					<th width="10%"> 우편번호 </th>
					<th width="15%"> 지번주소 </th>
					<th width="10%"> 운영기관명 </th>
					<th width="10%"> 충전소명 </th>
					<th width="10%"> 충전기타입명 </th>
					<th width="10%"> 경도 </th>
					<th width="10%"> 위도 </th>
				</tr>
		`
		r.data.forEach( (o)=>{
			/* 객체내 필드 호출하는 방법 :  1. 객체명.필드명 2. 객체명['필드명'] */
			
			html += `
				<tr>
					<td> ${o.시군명} </td>
					<td> ${o.소재지도로명주소} </td>
					<td> ${o.소재지우편번호} </td>
					<td> ${o.소재지지번주소} </td>
					<td> ${o.운영기관명} </td>
					<td> ${o.충전소명} </td>
					<td> ${o.충전기타입명} </td>
					<td> ${o ['경도(WGS84)'] } </td>
					<td> ${o ['위도(WGS84)'] } </td>
				</tr>
		`
		} )
		document.querySelector('.table').innerHTML =html;
		
		}
	})
}

