package 과제.과제9.인터페이스_반려동물;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		
		
	while(true) {
		System.out.print(">>1.고양이 2.강아지 : ");
		int ch = scanner.nextInt();
		if(ch == 1) {
			Animal animals;		
			animals = new Cat();		
			animals.bark();
			System.out.print("츄르 몇개 줄까? : ");
			int sno = scanner.nextInt();
			animals.eat(sno);
		}
		else if(ch == 2) {
			Animal animals;		
			animals = new Dog();		
			animals.bark();
			System.out.print("고구마 몇개 줄까? : ");
			int sno = scanner.nextInt();
			animals.eat(sno); 
			}
		}
	
	}
	
}
