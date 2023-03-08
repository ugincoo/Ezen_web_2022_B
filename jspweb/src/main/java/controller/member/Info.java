package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;

/**
 * Servlet implementation class Info
 */
@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }


	//1.회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 메소드 받음");
		///---------첨부파일 있을때---------
		/*
		  request는 첨부파일 에 대한 요청이 불가능 --> 외부라이브러리 (cos)
		  빌드패스 라이브러리 추가
		  webapp -> lib 추가 
		  -----
		  MultipartRequest 클래스 제공
		  	1. 요청방식 : http request
		  	2. 저장폴더 : 1.프로젝트(팀플시 사용) 2.서버 (배포시 사용)
		  		서버폴더 찾기 경로 :  request.getSession().getServletContext().getRealPath("(webapp생략)폴더명")
		  	3. 첨부파일 허용 용량
		  	4. 첨부파일 요청 한글 인코딩
		  	5. 첨부파일 파일명 중복 일 경우 뒤에 숫자 자동 부여 
		  -----
			//*현재 작업 프로젝트 위치 찾기 
			String path = "C:\\Users\\504\\git\\Ezen_web_2022_B\\jspweb\\src\\main\\webapp\\member\\pimg";
		 */

		//*현재 서버의 베포된 폴더 위치 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
		System.out.println(uploadpath);
		//* 업로드
		MultipartRequest multi = new MultipartRequest(
				request, 						//요청방식
				uploadpath,								//첨부파일 가져와서 저장 할 서버 내 폴더
				1024*1024*10,					//첨부파일 허용 범위 용량[바이트단위] 10MB
				"UTF-8",						//한글인코딩
				new DefaultFileRenamePolicy()	//동일한 첨부파일명이 존재하면 식별깨짐 -> 뒤에 숫자 붙여짐 
				);
		//그 외 매개변수 요청 [ request x , multi  사용 /form 하위 태그 내 input 태그의 name 식별ㅈㅏ]
		String mid	 	= multi.getParameter("mid");	//호출 할 input name
		String mpw 		= multi.getParameter("mpw");
		String memail 	= multi.getParameter("memail");
		String mimg 	= multi.getFilesystemName("mimg"); //첨부파일된 파일명 호출 [ getFilesystemName ]
		
		MemberDto dto = new MemberDto(0, mid, mpw, mimg, memail);
			System.out.println("dto : " + dto);
		boolean result = MemberDao.getinstance().signup(dto);
		response.getWriter().print(result);
		//---------첨부파일 없울때----------
		//한글 인코딩 요청
		/*request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String memail = request.getParameter("memail");
		String mimg = request.getParameter("mimg");
		//DTO 만들기
		MemberDto dto = new MemberDto(0, mid, mpw, mimg, memail);
			System.out.println(dto);
		//DAO 호출하고 결과 받기
		boolean result = MemberDao.getinstance().signup(dto);	
				
		//한글 인코딩 받기
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
		*/
	}

    //2. 로그인 / 회원정보 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 메소드 받음");
		
		//1. Dao에게 모든 회원명단 요청 후 저장
			ArrayList<MemberDto> result = MemberDao.getinstance().mdata();
		//2. jaja -> 
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(result);
			response.setCharacterEncoding("UTF-8");	
			response.setContentType("application.json"); // 전송 할 데이터 타입
			response.getWriter().print(jsonArray);
		
	}
	
	//3. 회원 정보 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	//4.회원탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
