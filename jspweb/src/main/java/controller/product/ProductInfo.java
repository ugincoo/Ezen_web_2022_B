package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dao.ProductWriteDao;
import model.dto.ProductWriteDto;

/**
 * Servlet implementation class info
 */
@WebServlet("/product/info")
public class ProductInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProductInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	ObjectMapper mapper = new ObjectMapper();
	
    //제품 목록 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String 동 = request.getParameter("동");	System.out.println("동 : "+동);
		String 서 = request.getParameter("서");	System.out.println("서 : "+서);
		String 남 = request.getParameter("남");	System.out.println("남 : "+남);
		String 북 = request.getParameter("북");	System.out.println("북 : "+북);
		
		
		ArrayList<ProductWriteDto> result = ProductWriteDao.getInstence().getProductList(동,서,남,북);
		
		String jsonArray = mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	//제품등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----------------------------------commons.jar 사용---------------------------------------------
		
		request.setCharacterEncoding("UTF-8");	//요청 한글 타입
		//1. 다운로드 할 서버 경로 찾기
		String 경로 = request.getSession().getServletContext().getRealPath("/product/pimg");
		
		//2. 해당 경로의 파일/폴더  객체화 [ setRepository 사용 해야하기 떄문 ]
		File 저장경로객체 = new File(경로);
		
		//3. 업로드 할 저장소 객체 생성
			// * DiskFileItemFactory( org.apache.commons.fileupload.disk.DiskFileItemFactory ) 
		DiskFileItemFactory 파일저장소 = new DiskFileItemFactory();
		파일저장소.setRepository(저장경로객체);			// 저장소 위치 대입 [ file 형태로 받아옴 ]
		파일저장소.setSizeThreshold(1024*1024*10); 	// 파일 저장 최대 용량 지정
		파일저장소.setDefaultCharset("UTF-8");
		
		//4. 파일 업로드 객체
			// * ServletFileUpload( org.apache.commons.fileupload.disk.DiskFileItemFactory ) 
		ServletFileUpload 파일업로드객체 = new ServletFileUpload(파일저장소); // 서블릿 파일업로드 객체
		
		try {
			//5. 매개변수 요청해서 리스트에 담기 [ 무조건 예외 처리 발생 ]
			List<FileItem> 파일아이템목록 =  파일업로드객체.parseRequest(request);
			//DB에 저장할 데이터를 분류 (업로드와는 상관 없다)
			List<String> 일반필드목록 = new ArrayList<>();
			List<String> 파일필드목록 = new ArrayList<>();
			//6. 요청된 모든 매개변수들을 반복문 돌려서 확인 
			for(FileItem item : 파일아이템목록) {
				//isFormField() : 폼 필드인지 확인 
				if( item.isFormField() ) { //첨부파일이 아니면 true/ 첨부파일이면 false
					System.out.println("첨부파일이 아닌 필드명: " + item.getFieldName());	
					System.out.println("첨부파일이 아닌 필드값: " + item.getString());	
					일반필드목록.add(item.getString());
				}else {
					System.out.println("첨부파일 필드명 :" + item.getFieldName());
					System.out.println("첨부파일 필드값: " + item.getName()); // 첨부파일에 getString 사용시 바이트 가져옴
					//9. 첨부파일 이름 식별이름으로 변경
						//1. 만약에 파일명에 공백이 존재하면 -로 변경 [ replace("기존문자", "새로운문자") 문자열 치환함수 ]
						//2. UUID : 범용 고유 식별자 [ 중복이 없는 식별자 만들기 ]
						//3. 최종 식별 파일명 : UUID 파일명
						// UUID - 네트워크상에서 고유성을 보장하는 ID를 만들기 위한 표준 규약
					String filename = UUID .randomUUID() +" "+ item.getName().replaceAll(" ", "-");
					//String filename = 날짜/시간 +" "+ item.getName().replace(" ", "-");
					
					파일필드목록.add(filename);
					//7. 저장할 경로 +/+파일명의 파일을 객체화
					File 업로드할파일 = new File(경로+"/"+filename);
					//8. 해당 파일 객체 저장 - 실제 업로드
					item.write(업로드할파일);
					
				}
				/*
					System.out.println("필드명 : " + item.getFieldName()); //매개변수 name 확인
					System.out.println("파일이름 : " + item.getName()); //매개변수가 파일일경우 파일명 확인 
					//7. 저장할 경로 +/+파일명의 파일을 객체화
					File 업로드할파일 = new File(경로+"/"+item.getFieldName());
					//8.해당 파일 객체 저장 
				 	item.write(업로드할파일);
				 */
			}
			System.out.println(일반필드목록.toString());
			System.out.println(파일필드목록.toString());
			
			int mno = MemberDao.getinstance().getMno((String)request.getSession().getAttribute("login"));
			
			ProductWriteDto  dto = new ProductWriteDto(일반필드목록.get(0), 일반필드목록.get(1), Integer.parseInt( 일반필드목록.get(2) ) ,
					일반필드목록.get(3), 일반필드목록.get(4), mno, 파일필드목록);
			System.out.println("dto : "+ dto.toString());
			boolean result = ProductWriteDao.getInstence().write(dto);
			response.getWriter().print(result);
		}catch (Exception e) {
			System.out.println("파일등록실패");
		}
		//
		
		
	}		
		
		//-----------------------------------cos.jar 사용 -------------------------------------------
		/*
		String path = request.getSession().getServletContext().getRealPath("/product/pimg");
		MultipartRequest multi = new MultipartRequest(
				request, path,1024*1024*10 , "UTF-8" , new DefaultFileRenamePolicy() );
		
		String pname = multi.getParameter("pname");
		String pcomment = multi.getParameter("pcomment");
		int pprice = Integer.parseInt( multi.getParameter("pprice") );
		String plat = multi.getParameter("plat");
		String plng = multi.getParameter("plng");
		
		//첨부파일 1개 이름 가져오기 
		String pfile = multi.getFilesystemName("pfile");
			System.out.println(pfile);
		//첨부파일 여러개 이름 가져오기 1
		String pfile1 = multi.getFilesystemName("pfile1");
		String pfile2 = multi.getFilesystemName("pfile2");
		String pfile3 = multi.getFilesystemName("pfile3");
		//첨부파일 여러개 이름 가져오기 2
			//multiple input에 등록된 여러 사진들의 이름 가져오기 불가능 [cos.jar 사용 x]
			//multiple 사용ㅅ다른 라이브러리 사용 - 
		Enumeration pfiles = multi.getFileNames(); // input type 이 file의 태그명 호출
		while( pfiles.hasMoreElements() ) {
			//해당 목록에 요소[Enumerat]가 존재하면 true 아니면 false
			String s = (String )pfiles.nextElement(); // 다음 요소 가져오기
			System.out.println("s : " + s);
		}
		
		ProductWriteDto  dto = new ProductWriteDto(pname, pcomment, pprice, plat, plng);
		boolean result = ProductWriteDao.getInstence().write(dto);
		response.getWriter().print(result);
		*/


	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
