package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;

/**
 * Servlet implementation class boardwrite
 */
@WebServlet("/boardwrite")
public class boardwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardwrite() {
        super();
        // TODO Auto-generated constructor stub
    }
    // 게시물출력(전체, 개별)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int type = Integer.parseInt( request.getParameter("type") );
		
		if( type == 1 ) { // 1. 전체 출력 
			ArrayList<BoardDto> result =BoardDao.getinstance().getBoardList();
			// java 형식 ---> js형식 
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray =  mapper.writeValueAsString( result );
			// 응답
			response.setCharacterEncoding("UTF-8");
			response.setContentType("applcation/json");
			response.getWriter().print( jsonArray );
		}else if( type == 2 ) { // 2. 개별 출력 
			int bno = Integer.parseInt( request.getParameter("bno") ) ;	System.out.println("bno:"+bno);
			// Dao 처리 
			BoardDto result = BoardDao.getinstance().getBoard(bno);
			// 형변환 처리
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);
			// 응답 처리
			response.setCharacterEncoding("UTF-8");
			response.setContentType("applcation/json");
			response.getWriter().print(json);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//*현재 서버의 베포된 폴더 위치 찾기
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
			System.out.println( "path : "+ path );
		// 3. 파일 복사 [ 입력받은[file] 대용량 바이트 복사하기 ]
			MultipartRequest multi = new MultipartRequest(
					request ,  path ,  1024*1024*10 , "UTF-8" ,
					new DefaultFileRenamePolicy() );
		System.out.println( "multi : " + multi );

		//그 외 매개변수 요청 [ request x , multi  사용 /form 하위 태그 내 input 태그의 name 식별자]
		int cno = Integer.parseInt(multi.getParameter("cno") );
			System.out.println(cno);
		String btitle = multi.getParameter("btitle");
			System.out.println(btitle);
		String bcontent = multi.getParameter("bcontent");
			System.out.println(bcontent);
		String bfile = multi.getFilesystemName("bfile");
			System.out.println(bfile);
		//회원제 게시판
			// 1. 로그인된 회원 mno 필요
		String mid = (String) request.getSession().getAttribute("login");
			// 2. mid --> mno
		int mno = MemberDao.getinstance().getMno(mid);
		//Dto
		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, cno);
			System.out.println("dto: "+dto);
		//Dao
		boolean result = BoardDao.getinstance().bwrite(dto);
		//응답
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
