package Day15.Ex1_p498;

public class Member {
	
	//필드
	public String id;
	//생성자
	public Member(String id) {
		this.id = id;
	}
	//메소드
		//주소번지 비교가 아는 내부 값 비교로 재정의[오버라이딩]
	@Override
	public boolean equals(Object obj) {
		
			//부모객체 instanceof 자식클래스 변환객체명
			//obj -> target
		// if(obj instanceof Member target) { //jdk 16이상
		 if(obj instanceof Member) {
			 Member target = (Member)obj;
			if(id.equals(target.id) ) {
				return true;
			}
		}
		return false;
	}
	
	
}
