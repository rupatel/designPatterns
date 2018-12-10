package design.patterns.behavorial;

public class ChainOfResponsibility {
	public static void main(String args[]) {
		Chain pos = new PosNumProcessor(new NegNumProcessor(new ZeroNumProcessor(null)));
		pos.process(10);
		pos.process(-10);
		pos.process(0);
	}
}
abstract class Chain {
	protected Chain successor;
	public Chain(Chain successor) {
		this.successor = successor;
	}
	public abstract void process(int num);
}

class PosNumProcessor extends Chain {
	public PosNumProcessor(Chain successor) {
		super(successor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(int num) {
		if(num >0)
			System.out.println("Pos Num :Processing Num" + num);
		else successor.process(num);
	}
}

class NegNumProcessor extends Chain {
	public NegNumProcessor(Chain successor) {
		super(successor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(int num) {
		if(num < 0)
			System.out.println("Neg Num :Processing Num" + num);
		else successor.process(num);
	}
}

class ZeroNumProcessor extends Chain {
	public ZeroNumProcessor(Chain successor) {
		super(successor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(int num) {
		if(num == 0)
			System.out.println("Zero Num :Processing Num" + num);
		else successor.process(num);
	}
}