package Day11.Ex4.pack2;

import Day11.Ex4.pack1.A;

//------------패키지2---------------
public class D extends A {
	public D() {}
	public void method1() {// 상속은 가능
		this.field = "value";
		super.field = "value";
		
		this.metod();
		super.metod();
	}
	public void mathod2() {//불가능
		
		A a = new A();
		a.field = "value"; 
		a.method();
	}
}
