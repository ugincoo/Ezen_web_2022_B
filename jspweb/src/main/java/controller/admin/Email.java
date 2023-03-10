package controller.admin;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.MemberDto;

/**
 * Servlet implementation class Email
 */
@WebServlet("/email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Email() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//이메일 인증 코드 보내기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//받을 회원 이메일 받기
		String memail = request.getParameter("memail");	System.out.println("memail : " + memail);
		//인증코드 만들기
		String auth = "";
		
		for(int i =0 ; i <6 ; i++) {//6자리 난수
			Random  random =new Random();
			auth += random.nextInt(10); //0~9 사이의 정수 생성				
		}
		System.out.println(auth);
		//3.인증코드와 받는 사람의 이메일에 보내기
		
		//
		boolean result =  new MemberDto().sendEmail(memail, auth);
		if(result) {//메일 보내기 성공하면 인증코드 보내기
			response.getWriter().print(auth);
		}else {//실패하면 false 보내기
			response.getWriter().print(result);
		}
		
		/*
			MemberDto dto = new MemberDto();
			dto.sendEmail(memail, auth);
		*/
		
	}

}
/*
	SMTP(간이 메일 전송 프로토콜):
	메일 서버(네이버,구글,다음)에게 우편 전송
*/