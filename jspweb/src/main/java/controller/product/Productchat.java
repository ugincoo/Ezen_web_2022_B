package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.admin.Alarm;
import model.dao.MemberDao;
import model.dao.ProductWriteDao;
import model.dto.ChatDto;

/**
 * Servlet implementation class productChat
 */
@WebServlet("/product/chat")
public class Productchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productchat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt( request.getParameter("pno") );
		int mno = MemberDao.getinstance().getMno( (String)request.getSession().getAttribute("login") );
		int chatmno = Integer.parseInt( request.getParameter("chatmno") );
		
		ArrayList<ChatDto> result = ProductWriteDao.getInstence().getChatList(pno, mno,chatmno);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	/*
	  	-"select * from note  where pno =? and (frommno =? or tomno = ?)";
	 		로그인된 회원 기준으로 보내거나 받은 메시지 모두 출력
	 		1. 구매자 문제 없음 2. 판매자는 채팅 대상자의 내용만 출력 해야 함 (문제 발생)
	 	-"select * from note  where pno =? and ( (frommno =? and tomno = ?) or (frommno =? and tomno = ?) )";
	 	만약에 4번회원과 5번회원이 존재 
	 	frommno =4 이면서 tomno = 5 이거나 frommno=5이면서 tomno=4
	 	-> 4번회원이 보냈거나 받았으면서 5번 회원이 받았거나 보냈으면 출력 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ncontent = request.getParameter("ncontent");
		int  pno = Integer.parseInt(request.getParameter("pno"));
		int frommno = MemberDao.getinstance().getMno( (String)request.getSession().getAttribute("login") );
		int tomno = Integer.parseInt(request.getParameter("tomno"));
		
		ChatDto dto = new ChatDto(0, ncontent, null, pno, frommno, tomno);
		System.out.println(dto);
		//3.
		boolean result = ProductWriteDao.getInstence().setChat(dto);
		//4. 만약에 채팅 등록이 성공했으면 받은 사람(tomno)에게 소켓 알림 메시지 보내기
		if(result) {
			//서버 소켓에게 채팅을 받은 유저의 번호와 내용을 전달 
			try {
				Alarm.서버메세지(null, tomno+","+ncontent);	//받는회원번호+,+쪽지내용
			}catch (Exception e) {
				System.out.println(e);
			}
		}//if e
		response.getWriter().print(result);
		
	}//post e

}
