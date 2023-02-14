package 과제.과제4싱글톤;

import 과제.과제4싱글톤.view.Front;
/*
 M : 데이터 모델링 [ 저장하고자 하는 데이터들의 설계 ]
 V : 입 출력
 C : 제어 / 비지니스로직 / 기능
 	예) 회원가입
 		V : 아이디 , 비밀번호 입력만
 		C : 입력받은 데이터를 유효성검사 후 저장
 		M : 입력받은 데이터를 저장할때 사용하는 모델링
 
 
 */
public class start {
	public static void main(String[] args) {
		Front.getInstance().index();
	}
}
