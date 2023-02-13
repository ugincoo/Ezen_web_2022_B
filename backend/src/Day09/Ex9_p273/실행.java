package Day09.Ex9_p273;

public class 실행 {
	public static void main(String[] args) {
		
		// 1. 생성자가private 여서 객체 생성 불가능
			//Member_싱글톤 member = new Member_싱글톤(); 
		//2. 객체 없이 메소드 [ static ] 호출	
		Member_싱글톤 m1 = Member_싱글톤.getInstance();
		Member_싱글톤 m2 = Member_싱글톤.getInstance();
		
		System.out.println(m1);
		System.out.println(m2);
		
	}
}
