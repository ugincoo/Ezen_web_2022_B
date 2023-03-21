package controller.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Api1
 */
@WebServlet("/api1")
public class Api1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Api1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 공공데이터 포털에서 신청한 데이터 가져오기[ 안산시 전기차 충전소현황 ]
			// URL 클래스
			// 1. .openStream() : 해당 객체의 연결된 url 스트림 제공 함수 [ 반환 : InputStraem ]
				//스트림 - 자바 외부에 연결된 데이터의흐름
		// URL url = new URL("URL주소") -> java.net
		URL url = new URL("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=d6G0imt5Vz21ZWQfaccWnoPsQ1pfEOSbMols03Bwa%2FgS88FT9gmyDyGD5hm5%2Fm2BFG%2FH%2BCDLkFzTLP3ZE1VTrg%3D%3D");
		
		//2. 해당 url의 데이터[ 스트림(바이트) ]읽어오기 위한 스트림 객체 생성
		//InputStream inputStream = url.openStream();
		//InputStreamReader reader = new InputStreamReader( url.openStream() ,"UTF-8" );
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8") );
		
			//*
			//byte[] array1 = new byte[100000];
			//char[] array2 = new char[100000];
			 
			
		//3. 스트림에서 바이트 읽어오기
			//읽기
		//inputStream.read(array1);			// 바이트 배열로 읽어오기
		//reader.read(array2);				// 문자 배열로 읽어오기
		String result = bf.readLine();		// 모든 바이트 읽은 후 문자열 반환
			System.out.println(result);

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
