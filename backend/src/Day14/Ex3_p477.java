package Day14;

public class Ex3_p477 {
	//1. p.478
	public static void findclass() throws Exception { // 예외 던지기
		Class.forName("java.lang.String2"); // 일반예외
	}
	
	public static void main(String[] args) throws Exception {
		try {
			findclass();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("확인");
	}
	
}
/*
 	예외 떠넘기기
 		- 메소드 내부에서 예외 발생 했을때 메소드 호출 했던 곳으로 예외를 넘기기
 		- throws 
 		- 메소드 마다 예외 처리를 하면 코드가 지저분해짐 -> 이동 후 한곳에서 처리
 */
