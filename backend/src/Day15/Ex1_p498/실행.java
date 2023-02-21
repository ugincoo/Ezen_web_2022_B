package Day15.Ex1_p498;

public class 실행 {
	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		System.out.println(obj1);
		Member obj2 = new Member("blue");
		System.out.println(obj2);
		Member obj3 = new Member("red");
		System.out.println(obj3);
		
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
		//주소가 다르기 때문에 false가 나옴 -> new 연산자 사용 할 때 마다 주소값 새로 생성!
		//로그인 만들때 활용 !_!
		
	}
}
