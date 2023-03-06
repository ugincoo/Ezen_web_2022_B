package practice.day01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex1
 */
@WebServlet("/ex1")
public class ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		//1. Dao 실행해서 데이터 호출
		ArrayList<String> result = Dao.getInstance().getData();
		//2. 확인
		System.out.println("확인 : " + result);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String data = request.getParameter("data"); // ajax (data :{"매개변수명" : 데이터} )
		System.out.println("JS post 방식으로 받은 데이터 : " + data);

		//1. DB연동
		boolean result = Dao.getInstance().setData(data);
		
		response.getWriter().print("post 메소드 형식으로 받았습니다."+result);
	}

}
//1. HTTP 객체[ request : JS에게 요청 ,response : JS에게 응답 ]
//0. 한글인코딩
	// 요청 : request.setCharacterEncoding("UTF-8");
	// 응답 : response.setCharacterEncoding("UTF-8");
//1. request.getParameter("매개변수명"); getParameter : 변수를 받아오다
//2. response.getWriter().print(데이터);