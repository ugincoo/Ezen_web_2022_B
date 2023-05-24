package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Dao;
import controller.Dto;

/**
 * Servlet implementation class vote
 */
@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글인코등
		request.setCharacterEncoding("UTF-8");
		// 2. 매개변수요청
		String v_jumin = request.getParameter("v_jumin");
		String v_name = request.getParameter("v_name");
		String m_no = request.getParameter("m_no");
		String v_time = request.getParameter("v_time");
		String v_area = request.getParameter("v_area");
		String v_confirm = request.getParameter("v_confirm");
		// 3. dto
		Dto dto = new Dto(m_no, v_jumin, v_name, v_time, v_area, v_confirm);
		// 4. dao
		Dao dao = new Dao();
		boolean result = dao.vote(dto);
		// 5. 성공시 페이지 전환
		if(result)response.sendRedirect("/HRD_3/index.jsp");
		else response.sendRedirect("/HRD_3/vote.jsp");
				
		
	}

}
