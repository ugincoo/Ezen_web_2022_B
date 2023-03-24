package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dao.ProductWriteDao;

/**
 * Servlet implementation class Plike
 */
@WebServlet("/product/like")
public class Plike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Plike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));	System.out.println(pno);
		int mno = MemberDao.getinstance().getMno( (String) request.getSession().getAttribute("login") ); System.out.println(mno);
		
		boolean result = ProductWriteDao.getInstence().getplike(pno, mno);
		response.getWriter().print(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));	System.out.println(pno);
		int mno = MemberDao.getinstance().getMno( (String) request.getSession().getAttribute("login") ); System.out.println(mno);
		
		boolean result = ProductWriteDao.getInstence().setplike(pno, mno);
		response.getWriter().print(result);
		
	}

}
