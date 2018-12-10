package design.patterns.behavorial;

public class StrategyClient {
	public static void main(String args[]) {
		Composition c = new Composition(new PayPal());
		c.makePayment();
	}
}

class Composition{
	private PaymentCompositor pc;
	public Composition(PaymentCompositor pc) {
		this.pc = pc;
	}
	public void makePayment() {
		pc.pay();
	}
}


interface PaymentCompositor{
	public void pay();
}

class PayPal implements PaymentCompositor{
	@Override
	public void pay() {
		System.out.println("pay via paypall");
	}
}

class DebitCard implements PaymentCompositor{
	@Override
	public void pay() {
		System.out.println("pay via debit card");
	}	
}