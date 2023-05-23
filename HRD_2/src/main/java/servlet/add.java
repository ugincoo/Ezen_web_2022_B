package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cotroller.Dao;
import cotroller.Dto;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 요청
		String sno = request.getParameter("sno");
		int ekor = Integer.parseInt(request.getParameter("ekor"));
		int emath = Integer.parseInt(request.getParameter("emath"));
		int eeng= Integer.parseInt(request.getParameter("eeng"));
		int ehist = Integer.parseInt(request.getParameter("ehist"));
		
		//2. dto
		Dto dto =  new Dto(sno, ekor, emath, eeng, ehist);
		System.out.println(dto);
		//3. dao
		Dao dao = new Dao();
		boolean result = dao.add(dto);
		System.out.println(result);
		if(result) { response.sendRedirect("/HRD_2/add.jsp");}
		else {}
		}
		
	

}
