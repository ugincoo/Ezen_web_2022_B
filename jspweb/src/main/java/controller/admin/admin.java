package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.adminpage;

/**
 * Servlet implementation class admin
 */
@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 메소드 받음");
		
		//----검색---
		String key = request.getParameter("key");
		//System.out.println(key);
		String keyword = request.getParameter("keyword");
		//System.out.println(keyword);
		//-------페이징처리--------
		//현재페이지 / 회원출력 시작번호, 끝번호 
		int page = Integer.parseInt(request.getParameter("page"));			//현재페이지
		//System.out.println(page);
		int listsize = Integer.parseInt(request.getParameter("listsize")); // 출력할 게시물 개수
		//System.out.println(listsize);
		int startrow = (page-1)*listsize; //페이지 게시물 시작번호 
		//System.out.println(startrow);
		
		//----버튼만들기----
		int totalsize = MemberDao.getinstance().totalsize(key,keyword);
		//System.out.println(totalsize);
		int totalpage = totalsize%listsize == 0 ? totalsize/listsize :  totalsize/listsize+1;
		//System.out.println(totalpage);
		int btnsize = 5; //최대버튼 출력 개수
		int startbtn = ( (page-1)/btnsize )*btnsize+1;
		int endbtn = startbtn+btnsize-1;
		//마지막 버튼 수가 총 페이지보다 많으면 마지막 버튼 숫자는 총 게시물 숫자
		if(endbtn > totalpage)endbtn = totalpage;
		//1. Dao에게 모든 회원명단 요청 후 저장
		ArrayList<MemberDto> result = MemberDao.getinstance().getdata(startrow,listsize,key,keyword);
		System.out.println(result);
		//dto 
		adminpage adminpage = new adminpage(page, listsize, startrow, totalsize, totalpage, btnsize, startbtn, endbtn,result);
		System.out.println(adminpage);
		//2. java -> 
			ObjectMapper mapper = new ObjectMapper();
			String jsonArray = mapper.writeValueAsString(adminpage);
			response.setCharacterEncoding("UTF-8");	
			response.setContentType("application.json"); // 전송 할 데이터 타입
			response.getWriter().print(jsonArray);
		//------------------------------------------------------------------------
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
