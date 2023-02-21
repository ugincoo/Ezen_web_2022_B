package Day15.Ex4_p514;

public class system클래스 {
	public static void main(String[] args) {
		//1.
		System.out.println("출력");
		System.err.println("에러");
		
		int value = 100;	//이상없음 [ 정수니까 가능 ]
		//int value2 = "100";	//"100" 불가
			//문자열 --> 기본타입 [항변환]
		int vlaue3 = Integer.parseInt("100");	//"100" -> 숫자 100
		
		try {//에러가 발생 할 거 같은 코드			
			int vlaue4 = Integer.parseInt("1oo");	//"1oo" -> 문자여서 불가능
		}
		catch (Exception e) {//try에서 예외가 발생했을때 catch 실행
			System.err.println("에러내용");
			System.out.println(e.getMessage());
		}
		//2. p.514
		int speed = 0;
		int keycode = 0;
		
		while(true) {
			if(keycode != 13 && keycode != 10) {//엔터[13,10]가 아니고
				if(keycode == 49) {//숫자1 코드
					speed++;
				}else if (keycode == 50) {//숫자2 코드
					speed--;
				}else if (keycode == 51) {//숫자3 코드
					//break;
					System.exit(0);
				}
				
				System.out.println("현재속도 : " + speed);
				System.out.println("1.증속 2.감속 3.정지 : ");
			}

			try {
				keycode = System.in.read();	//입력받기}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}//while end
	//	System.out.println("프로그램종료"); // break 사용할때 
		
	}
}
