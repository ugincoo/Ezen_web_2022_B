package Day11.Ex4.pack2;

import Day11.Ex4.pack1.A;

//------------패키지2---------------
public class C {
	public void method() {
		A a = new A();	// X public가능 protected불가능
		a.field = "value";
		a.metod();
	}
}
