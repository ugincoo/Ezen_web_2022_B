package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.ReplyDto;

/**
 * Servlet implementation class Reply
 */
@WebServlet("/board/reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reply() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int type= Integer.parseInt(request.getParameter("type"));
		int rindex = 0;
		
		if (type==1) {
		
		}else if (type == 2) {
			rindex = Integer.parseInt(request.getParameter("rindex"));
		}
		
		
		ArrayList<ReplyDto> result = BoardDao.getinstance().getReplyList(bno,rindex);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		request.setCharacterEncoding("UTF-8");
		int bno = Integer.parseInt(request.getParameter("bno"));
		int mno =MemberDao.getinstance().getMno((String)request.getSession().getAttribute("login"));
		String rcontent = request.getParameter("rcontent");
		
		int type = Integer.parseInt(request.getParameter("type"));
		
		ReplyDto dto = new ReplyDto(rcontent, mno, bno);
		if(type==1) {

		}else if(type==2) {
			int rindex = Integer.parseInt(request.getParameter("rindex"));
			dto.setRindex(rindex);
		}
		System.out.println("dto"+dto);
	
		//DAO 호출
		boolean result = BoardDao.getinstance().rwite(dto);
		//응답받기
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
