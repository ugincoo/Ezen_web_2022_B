package practice.day02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class q2
 */
@WebServlet("/q2")
public class q2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public q2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Dto2> list2 = Dao.getInstance().getdata2();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(list2);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print( jsonArray );
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String 이름 = request.getParameter("이름");
		String 전화번호 = request.getParameter("전화번호");
		String 키 = request.getParameter("키");
		int 나이 = Integer.parseInt( request.getParameter("나이") );
		String 등록일 = request.getParameter("등록일");
		String 성별 = request.getParameter("성별");
		boolean 동의 = Boolean.parseBoolean( request.getParameter("동의") ) ;
		String 지역 = request.getParameter("지역");
		String 자기소개 = request.getParameter("자기소개");

		
		
		
		request.setCharacterEncoding("UTF-8");
		Dto2 dto2 = new Dto2(이름, 전화번호, 키, 나이, 등록일, 성별, 동의, 지역, 자기소개);
		boolean result = Dao.getInstance().setData2(dto2);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
