package 과제.과제6;

public class Tire {//상위생성자
	// 1. 필드
	public int maxRotation; 		 // 회전 최대치
	public int accumulatedRotation;  //누적 회전
	public String location;			 //위치
	//생성자
	public Tire(int maxRotation, String location) {//모든 곳에서 호출 가능한 매개변수o 리턴 o
		this.maxRotation = maxRotation;
		this.location = location;
	}
	//메소드
	public boolean roll() {
		++accumulatedRotation; // 누적회전 증가
		if( accumulatedRotation < maxRotation ) {//만약 누적회전이 회전 최대치보다 작으면
			System.out.println( location + " Tire 수명 : " 
				+ (maxRotation-accumulatedRotation) + "회");
			return true; 
		}else {
			System.out.println("*** " + location +" Tire 펑크 ***");
			return false; 
		}
	}
}