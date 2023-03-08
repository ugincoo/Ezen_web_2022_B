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
 * Servlet implementation class p3
 */
@WebServlet("/Ex3/p3")
public class p3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public p3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		ArrayList<SpringDto> rssult = SpringDao.getinstance().ondata();
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(rssult);
		//
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청시 한글 인코딩
				request.setCharacterEncoding("UTF-8");
				//2. 매개변수 요청 [ ajax data속성에서 보내준 변수  ]
				String sname = request.getParameter("sname");
					System.out.println("sname : " + sname);
				int sprice = Integer.parseInt(request.getParameter("sprice") );
					System.out.println("sprice : " + sprice);	
				//3. DTO 객체화 [ int = 기본값 0 / String = 기본값 null ]
				SpringDto dto = new SpringDto(0, sname, sprice);
					System.out.println("dto : " + dto);
				//4. DAO 호출하여 결과 저장
				boolean result =  SpringDao.getinstance().on(dto);
					System.out.println("result :" + result);
				//5. dao 결과 -> true/false
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(result);	
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newName = request.getParameter("newName");
		int newPrice = Integer.parseInt(request.getParameter("newPrice"));
		int sno = Integer.parseInt(request.getParameter("sno"));
		boolean result = SpringDao.getinstance().update(newName, newPrice, sno);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno = Integer.parseInt(request.getParameter("sno"));
		boolean result = SpringDao.getinstance().delete(sno);
		response.getWriter().print(result);
	}

}
