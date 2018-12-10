package design.patterns.structural;

public class Composite {
	public static void main(String args[]) {
		Exp e = new Sub(new Add(new Num(10), new Num(20)),new Add(new Num(1), new Num(3)));
		System.out.println(e.eval());
	}
}

abstract class Exp{
	public abstract int eval();
}
class Add extends Exp{
	Exp e1;
	Exp e2;
	public Add(Exp e1, Exp e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	@Override
	public int eval() {
		return e1.eval() + e2.eval();
	}
}

class Sub extends Exp{
	Exp e1;
	Exp e2;
	public Sub(Exp e1, Exp e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	@Override
	public int eval() {
		return e1.eval() - e2.eval();
	}
}

class Num extends Exp{
	int x;
	public Num(int x) {
		this.x = x;
	}
	public int eval() {
		return x;
	}
}