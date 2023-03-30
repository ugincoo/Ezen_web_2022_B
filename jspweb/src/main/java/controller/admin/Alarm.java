package controller.admin;

import java.util.ArrayList;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dao.MemberDao;
import model.dto.ClientDto;



@ServerEndpoint("/alarm/{mid}")
public class Alarm {
	
	private static ArrayList<ClientDto> 알림명단 = new ArrayList<>();
	
	
	@OnOpen		// 클라이언트 소켓이 들어 왔을때 매핑 [연결]
	public void 서버입장(Session session, @PathParam("mid")String mid ) throws Exception {
		알림명단.add(new ClientDto(session, mid) );
		}
	
	@OnClose	// 클라이언트 소켓이 나갔을때 매핑 [연결]
	public void 서버나가기(Session session ) throws Exception {
		for(ClientDto c : 알림명단) {
			if(c.getSession() == session) {
				알림명단.remove(c);
			}
		}
	}
	
	@OnError	// 클라이언트 소켓이 에러가 발생했을때 매핑 [연결]
	public void 서버오류(Session session , Throwable e) throws Exception {System.out.println(e); }
	
	@OnMessage	// 클라이언트 소켓이 메세지를 보낼때 매핑 [연결] !! 필수로 정의할 인수
	public static void 서버메세지(Session session ,String msg) throws Exception {
		//메세지를 받는 회원번호 
		int tomno = Integer.parseInt( msg.split(",")[0] );
		//메세지 내용
		String tomsg = msg.split(",")[1];
		for(ClientDto c :알림명단) {
			
			int cmno = MemberDao.getinstance().getMember(c.getMid()).getMno();
			if(cmno == tomno) {//받는 회원번호가 알림 명단에 존재하면 메세지 보냄 
				c.getSession().getBasicRemote().sendText(tomsg);
			}
		}
	}
}
/*
	Session session : 요청한 클라이언트 소켓
	Throwable e		: 에러 발생시 에러 이유가 저장된 변수 
	String s		: 요청받은 메세지 내용
	서버소켓
		1. @ServerEndpoint  :  서버의 경로 만듬
		2. @OnOpen			: 필수 매개변수 - Session session
		3. @OnClose			: 필수 매개변수 - Session session
		4. @OnError			: 필수 매개변수 - Session session , Throwable e
		5. @OnMessage		: 필수 매개변수 - Session session , String s
		6. @PathParam		: 경로상의 변수요청
*/