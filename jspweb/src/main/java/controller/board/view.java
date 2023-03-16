package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;

/**
 * Servlet implementation class view
 */
@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type=Integer.parseInt( request.getParameter("type") );
			System.out.println(type);
		int bno=Integer.parseInt( request.getParameter("bno") );
			System.out.println(bno);
		/* 
		 	특정시간 - 하루에 한번씩 조회수 or 좋아요 or 싫어요 증가 가능
			회원별 vs pc별
		*/
		//1. pc 네트워크 식별자[ip]
			//1. java에서 현재 요청한 클라이언트의 ip 확인
		String ip = request.getRemoteAddr();
			System.out.println(ip);
			//4. 만약에 기존 세션이 없으면 증가가능 있으면 증가 불가
		Object o = request.getSession().getAttribute(type+ip+bno);
		if(o == null ) {//세션[bno+type+ip]이 생성된 적이 없다.
				//2. 세션 생성[ip+type+bno]
			request.getSession().setAttribute(type+ip+bno, 1);
				//3. 세션 허용시간(생명주기)지나면 메모리 자동 메모리삭제[로그아웃]
					//세션 초기화 기준 
						//서버 끄면 / 서버재부팅 / MaxInactiveInterval 설정한 시간이 지났을때
			request.getSession().setMaxInactiveInterval(60*60*24);
			//DAO
			 boolean result = BoardDao.getinstance().bIncrease(type,bno);
			 response.getWriter().print(result);
		}
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
