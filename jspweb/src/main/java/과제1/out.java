package 과제1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class out
 */
@WebServlet("/out")
public class out extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public out() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Company.java:::열림");
        request.setCharacterEncoding("UTF-8");   
       
        
        String cedate=request.getParameter("cedate");
        System.out.println("Company.java doDelete cedate :::"+cedate);

        String cecontent=request.getParameter("cecontent");
        System.out.println("Company.java doDelete cecontent :::"+cecontent);
        
        int cno = Integer.parseInt(request.getParameter("cno"));
        System.out.println("Company.java doDelete cno:::"+cno);
        
        boolean result = Dao.getInstance().out(cedate,cecontent,cno);
        response.getWriter().print(result);
	}
}
