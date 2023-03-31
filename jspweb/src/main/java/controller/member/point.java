package controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.ProductWriteDao;

/**
 * Servlet implementation class point
 */
@WebServlet("/point")
public class point extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public point() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Integer> result =  ProductWriteDao.getInstence().getsum();
		System.out.println("json 변환 전 :" +result.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
			System.out.println("json 변환 후 :" + json);
		
		response.setContentType("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpcomment = request.getParameter("mpcomment");
		int mpamount = Integer.parseInt(request.getParameter("mpamount"));
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		boolean result = MemberDao.getinstance().setPoint(mpcomment, mpamount, mno);
		response.getWriter().print(result);
					
	}

}
