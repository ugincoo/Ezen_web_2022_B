package Day09.Ex8.package1;
/*


	접근 제한자 : 해당 클래스,핖드 생성자,메소드 접근을 제한하는 연산자
		public 		vs		 private
		모든곳에서 사용		현재 클래스에서만 사용
		
		생략(defalut)		protected
		같은 패키지내에서		같은 패키지내에서
							+ 다른 패키지일 경우 자식 클래스 가능
 */



public class A {

		A a1 = new A(true);
		A a2 = new A(1);
		A a3 = new A("문자열");
		//1. public 생성자
		public A(boolean b) {}
		//2. default 생성자
		A(int b){}
		//3. private 생성자
		private A (String s) {}
		
		//1. public 필드 
		public int field1;
		//2. default 필드
		int field2;
		//3. private 필드
		public int field3;
			
}
