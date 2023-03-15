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
		request.setCharacterEncoding("UTF-8");
		
		String cedate = request.getParameter("cedate");
			System.out.println(cedate);
		String cecontent = request.getParameter("cecontent");
		   	System.out.println(cecontent);
		      // 2. Dao에게 요청후 결과 받기 
		   	SDto dto = new SDto(0, null, null, null, null, null, null, cedate, cecontent);
		   boolean result = Dao.getInstance().out(cedate ,cecontent,0) ;    
		   System.out.println( "result : " + request );
		      // 3. 결과 ajax에게 보내기 
		   response.setCharacterEncoding("UTF-8");
		   response.getWriter().print(result);
	}

}
