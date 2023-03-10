package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;

/**
 * Servlet implementation class Find
 */
@WebServlet("/find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 입력받은 타입 요청
		String type =request.getParameter("type");
		String result = null;// 보낼결과
		
		if(type.equals("1")) {//아이디 찾기
			String memail = request.getParameter("memail"); //이메일 요청
			result = MemberDao.getinstance().findid(memail);
		}else if(type.equals("2")) {// 비밀번호찾기
			String mid = request.getParameter("mid");
			String memail = request.getParameter("memail");
			
			Random random = new Random();
			// 표현 할 난수 목록 만들기
			String ranStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			//임시 비밀번호 만들기(난수)
			String updatePw = "";
				//1. 12자리수
			for (int i = 0 ; i <12  ; i ++) {	
			int ran = random.nextInt(ranStr.length());
			updatePw+= ranStr.charAt(ran);
			System.out.println(ran);
			}
			
			result = MemberDao.getinstance().findpw(mid,memail,updatePw);
		}
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
