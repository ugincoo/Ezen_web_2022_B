package controller.board;

import java.io.File;
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
import model.dto.PageDto;

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
			//----------------------검색----------------
			//1.카테고리 매개변수 요청 	2.gettotalsize,getBoardLis
			int cno = Integer.parseInt(request.getParameter("cno"));
			
			
			
			//----------------------검색----------------
			//1. 검색에 필요한 매개변수 요청[ key- 필드 keyword ] 2.gettotalsize,getBoardList 조건 전달
			String key = request.getParameter("key");
				System.out.println(key);
			String keyword = request.getParameter("keyword");
				System.out.println(keyword);
			
			//페이징 처리
			//1. 현재페이지[요청] 2.현재페이지[게시물시작번호,게시물 끝번호 - 몇개씩 출력할건지..]
			int page = Integer.parseInt(request.getParameter("page"));
			int listsize = Integer.parseInt(request.getParameter("listsize")); //화면에 표시할 게시물 수 요청 ->js
			int startrow = (page-1)*listsize; //해당 페이지에서 게시물의 시작 번호
			//-----------page 버튼 만들기 ------------
			//1. 전체 페이지수[총게시물(레코드)수 / 페이지당 표시 수 ] 2.페이지에 표시할 최대 버튼수  3.시작버튼 번호
			
				//1. 검색이 없을때
			//int totalsize = BoardDao.getinstance().gettotalsize();
				//2. 검색이 있을때
			int totalsize = BoardDao.getinstance().gettotalsize(key,keyword,cno);
			
			int totalpage = totalsize % listsize == 0 ? totalsize/listsize : totalsize/listsize+1;
							//만약에 나머지가 0이면
			int btnsize = 5; //최대 버튼 출력수
			int startbtn = ( (page-1)/btnsize ) * btnsize+1;

			int endbtn = startbtn+btnsize-1 ;
			//* 마지막 버튼수가 총 페이지수보다 커지면 막는다 -> 마지막버튼은 총페이지로
			if(endbtn > totalpage) endbtn = totalpage;
			
			//검색이 없을때
			//ArrayList<BoardDto> result =BoardDao.getinstance().getBoardList(startrow,listsize);							
			//검색이 있을때
			ArrayList<BoardDto> result =BoardDao.getinstance().getBoardList(startrow,listsize,key,keyword,cno);	
			//pagsDto 만들기
			PageDto pagedto = new PageDto(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn, result);
					
			// java 형식 ---> js형식 
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray =  mapper.writeValueAsString( pagedto ); //pageDto 사용 전 - result 
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
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		System.out.println( "path : "+ path );
		// 3. 파일 복사 [ 입력받은[file] 대용량 바이트 복사하기 ]
		MultipartRequest multi = new MultipartRequest(
				request ,  path ,  1024*1024*10 , "UTF-8" ,
				new DefaultFileRenamePolicy() );
		System.out.println( "multi : " + multi );

		//수정된 정보 호출
		int bno = Integer.parseInt( multi.getParameter("bno") );
		int cno = Integer.parseInt( multi.getParameter("cno") );
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		/*첨부파일의 수정 경우의 수 
			//1. 기존에 첨부파일이 없었다 --> 새로운 첨부파일이 있다.
								   --> 새로운 첨부파일이 없다.
			//2. 기존에 첨부파일이 있었다 -->	새로운 첨부파일이 있다
			 					   --> 새로운 첨부파일이 없다	
		*/
		//1. 수정된 기존 첨부파일명 가져오기
		String oldfile = BoardDao.getinstance().getBoard(bno).getBfile();
		if(bfile == null) {	//새로운 첨부파일이 없다 
			bfile = oldfile;	//기존 첨부파일명 대입
		}else { // 새로운 첨부파일이 있다
			//삭제할 첨부파일 경로 찾기 
			String filepath = request.getSession().getServletContext().getRealPath("/board/bfile/"+oldfile);
			//파일 삭제 처리
			File file = new File(filepath);
			if(file.exists()) file.delete();
		}
		
		BoardDto dto = new BoardDto(bno, cno, btitle, bcontent, bfile);
			System.out.println("dto : " + dto);
		//dao	
		boolean result = BoardDao.getinstance().bupdate(dto);
		//응답
		response.getWriter().print(result);
	
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int type = Integer.parseInt(request.getParameter("type"));
		boolean result = true;
		//[공통] 삭제 전 첨부파일 명 구하기 
		String bfile = BoardDao.getinstance().getBoard(bno).getBfile();
		
		if(type==1) {//db삭제
			 result =  BoardDao.getinstance().bdelete(bno);
		}else if(type==2) {//db업데이트+파일삭제
			result = BoardDao.getinstance().filedelete(bno);
		}
		
		
		if(result) {// [공통] 파일삭제
			String path = request.getSession().getServletContext().getRealPath("/board/bfile/"+bfile);
			File file = new File(path);
			if(file.exists() ) {//만약에 파일이 존재하면
				file.delete(); //파일삭제
			}
			
		}		
		response.getWriter().print(result);
	}

}

/*
	1페이지 : 1-1 / *5 +1	-> 0*5+1 ->1
	2페이지 : 2-1 / *5 +1	-> 0*5+1 ->1
	3페이지 : 3-1 / *5 +1	-> 0*5+1 ->1
	4페이지 : 4-1 / *5 +1	-> 0*5+1 ->1
	5페이지 : 5-1 / *5 +1	-> 0*5+1 ->1
	6페이지 : 6-1 / *5 +1	-> 1*5+1 ->6
*/

/*
	ex) 
	총 게시물 = 10 , 페이지당 게시물 수 = 3
	1. 총 페이지수 - 123, 456, 789, 10 총 4개
		총 레코드수/페이지당 표시 게시물 수
			1. 나머지가 없으면 =>몫		9/3->3페이지
			2. 나머지가 있으면 =>몫+1		10/3->4페이지
	2. 페이지별 게시물 시작 pk번호 
		--> 1페이지 요청시 : (1-1)*3 = 0,  2페이지 요청시 : (2-1)*3 = 3
						-> 레코드 시작번호 : 0
	3. 시작버툰,마지막버튼 수 
	7페이지	btnsize = 5
			시작번호 - 1 6 11 16
	1페이지 -> 12345
	2페이지 -> 12345
	3페이지 -> 12345
	4페이지 -> 12345
	5페이지 -> 12345
	6페이지 -> 67
	7페이지 -> 67
*/