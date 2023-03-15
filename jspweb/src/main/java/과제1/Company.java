package 과제1;

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

/**
 * Servlet implementation class Company
 */
@WebServlet("/company")
public class Company extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Company() {
        super();
        // TODO Auto-generated constructor stub
    }

	//인사출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//dao 호출
		ArrayList<SDto> result = Dao.getInstance().sData();
		//json
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);

		//응답 받기
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application.json");
		response.getWriter().print(jsonArray);

	}

	//인사등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글인코딩요청
		request.setCharacterEncoding("UTF-8");
		//서버에 배포된 폴더 위치 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("pratice/과제1/img");
		System.out.println(uploadpath);
		//업로드
		MultipartRequest multi = new MultipartRequest(
				request, 						//요청방식
				uploadpath,						//첨부파일 가져와서 저장 할 서버 내 폴더
				1024*1024*10,					//첨부파일 허용 범위 용량[바이트단위] 10MB
				"UTF-8",						//한글인코딩
				new DefaultFileRenamePolicy()	//동일한 첨부파일명이 존재하면 식별깨짐 -> 뒤에 숫자 붙여짐 
				);
		//그 외 매개변수 요청
		String cimg = multi.getFilesystemName("cimg");
			System.out.println(cimg);
		String cname = multi.getParameter("cname");
			System.out.println(cname);
		String clevel = multi.getParameter("clevel");
			System.out.println(clevel);
		String cform = multi.getParameter("cform");
			System.out.println(cform);
		String cclassfy = multi.getParameter("cclassfy");
			System.out.println(cclassfy);
		String csdate = multi.getParameter("csdate");
			System.out.println(csdate);
		String cedate = multi.getParameter("cedate");
			System.out.println(csdate);
		String cecontent = multi.getParameter("cecontent");
			System.out.println(csdate);
			
		SDto dto = new SDto(0, cimg, cname, clevel, cform, cclassfy, csdate, csdate, csdate);
			System.out.println(dto);
		boolean result = Dao.getInstance().signup(dto);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
		
	}

	//인사수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글인코딩요청
		request.setCharacterEncoding("UTF-8");	
			
			//그 외 매개변수 요청
			
			String clevel = request.getParameter("clevel");
				System.out.println(clevel);
			String cform = request.getParameter("cform");
				System.out.println(cform);
			String cclassfy = request.getParameter("cclassfy");
				System.out.println(cclassfy);
				int cno = Integer.parseInt(request.getParameter("cno"));
				System.out.println(cno);
				
			boolean result = Dao.getInstance().update(cno,clevel,cform, cclassfy);
			response.getWriter().print(result);
			
	}

	  //인사삭제
	   protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	   String cname = request.getParameter("cname");
	   	System.out.println(cname);
	      // 2. Dao에게 요청후 결과 받기 
	   boolean result = Dao.getInstance().delete(cname);         
	   System.out.println( "result : " + request );
	      // 3. 결과 ajax에게 보내기 
	   response.getWriter().print(result);
	  }
}
