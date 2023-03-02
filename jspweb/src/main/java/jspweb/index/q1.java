package jspweb.index;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspweb.model.Dao;

/**
 * Servlet implementation class q1
 */
@WebServlet("/q1")
public class q1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public q1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩 받기
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<String> result = Dao.getInstance().getQ1();
		System.out.println(result);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩 출력?
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String data = request.getParameter("data");
		System.out.println("post로 받은 데이터" + data);
		//DB연동
		boolean result = Dao.getInstance().setQdata(data);
		response.getWriter().print("post 메소드로 받았습니다. " + "DB연동여부 : " + result);
	}

}
