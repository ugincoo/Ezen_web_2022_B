package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Board
 */
@WebServlet("/Ex3/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        
    }

    //게시물 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		//dao arrayList 저장
		ArrayList<BoardDto> result = BoardDao.getinstance().getdata();
		//json형식위 문자열로 변환
		ObjectMapper mapper = new ObjectMapper();	//1. jackson 라이버리에서 제공앟는 클래스
		String jsonString =  mapper.writeValueAsString(result); // 2. DAO로 부터 받은 리스트를 변환하기
		//응답
		response.setContentType("application/json");
		response.getWriter().print(jsonString);		
	}

	//게시물 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청시 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		//2. 매개변수 요청 [ ajax data속성에서 보내준 변수  ]
		String content = request.getParameter("content");
			System.out.println("content : " + content);
		String writer = request.getParameter("writer");
			System.out.println("writer : " + writer);	
		//3. DTO 객체화 [ int = 기본값 0 / String = 기본값 null ]
		BoardDto boardDto = new BoardDto( 0, content, writer, null );
			System.out.println("dto : " + boardDto);
		//4. DAO 호출하여 결과 저장
		boolean result =  BoardDao.getinstance().onwite(boardDto);
			System.out.println("result :" + result);
		//5. dao 결과 -> true/false
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);	
	}

	//게시물 삭제	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 항변환 매개변수 요청 [매개변수 못들어감 (null) ->  ] 
		int bno =Integer.parseInt( 
				request.getParameter("bno")
				);
			System.out.println("삭제 할 번호 : " + bno);
		//dao 호출
		boolean result = BoardDao.getinstance().ondelete(bno);
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt(
				request.getParameter("bno")
				);
		System.out.println("수정 할 번호 : " + bno);
		String newContent = request.getParameter("newContent");	
		//dao 호출
		boolean result = BoardDao.getinstance().onupdate(newContent, bno);
		response.getWriter().print(result);
	}


}
/*
	JSP 서블릿 http 메소드 put,delete 사용시 필수 설정
	1. severs 클릭
	2. server.xml
	3.60번대 줄
	<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443">
	-> <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URIEncoding="UTF-8" />
*/