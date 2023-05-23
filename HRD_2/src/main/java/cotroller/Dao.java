package cotroller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

public class Dao {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","system","1234");
		return con;
		
	}
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//3. 생성자
	public Dao() {
		try {
			con = getConnection();
			System.out.println("연동성공");
		}catch (Exception e) {
			System.out.println("연동실패 : " + e);
		}
		
	} // 3 end
	
	//4. 함수
	
	//4-1 학생목록 호출
	public List<Dto> getlist(){
		List<Dto> list = new ArrayList();
		String sql = "select * from student_tbl_03";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Dto dto = new Dto(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5));
				list.add(dto);
			}			
		}catch (Exception e) {
			System.out.println("e :" + e);
		}
		return list;
		
	} // getlist end
	
	// 4-2 점수 등록
	public boolean add(Dto dto) {
		String sql = "insert into exam_tbl_03 values (?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getSno());
			ps.setInt(2, dto.getEkor());
			ps.setInt(3, dto.getEmath());
			ps.setInt(4, dto.getEeng());
			ps.setInt(5, dto.getEhist());
			ps.executeUpdate();
			return true;
			}			
		catch (Exception e) {
			System.out.println("e :" + e);
		}
		return false;
	}
	
	//4-3
	public List<Dto> getExamlist(){
		 List<Dto> list = new ArrayList<>();
		 String sql = "select "
		 		+ "	substr(A.sno,1,1)학년,"
		 		+ "	substr(A.sno,2,2)반,"
		 		+ "	substr(A.sno,4,2)번호,"
		 		+ "	A.sname 이름,"
		 		+ "	B.ekor 국어,"
		 		+ " B.emath 수학,"
		 		+ "	B.eeng 영어,	"
		 		+ "	B.ehist 역사,"
		 		+ "	(B.ekor+B.emath+B.eeng+B.ehist)합계,"
		 		+ "	(B.ekor+B.emath+B.eeng+B.ehist)/4평균,"
		 		+ "	rank() over (order by (nvl(B.ekor,0)+nvl(B.emath,0)+nvl(B.eeng,0)+nvl(B.ehist,0)) desc)순위"
		 		+ " from student_tbl_03 A "
		 		+ "	full outer join "
		 		+ " exam_tbl_03 B "
		 		+ "	on A.sno = B.sno "
		 		+ " order by (nvl(B.ekor,0)+nvl(B.emath,0)+nvl(B.eeng,0)+nvl(B.ehist,0)) desc";
		 try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					Dto dto = new Dto(rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4),rs.getInt(5),rs.getInt(6),
							rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getDouble(10),rs.getInt(11));
					list.add(dto);
				}			
			}catch (Exception e) {
				System.out.println("e :" + e);
			}
			return list;
		 
	}
	
	
}
