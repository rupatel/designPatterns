package design.patterns.behavorial;

public class TemplateMethod {
	public static void main(String args[]) {
		ProcessStoreOrder o = new ProcessStoreOrder();
		o.process();
	}
}

abstract class OrderProcessingTemplate{
	
	public boolean isGift;
	public abstract void makePaymet();
	public abstract void deliver();
	//template method
	public void process() {
		makePaymet();
		if(isGift)
			System.out.println("warring item ...");
		deliver();
	}
}

class ProcessStoreOrder extends OrderProcessingTemplate{

	@Override
	public void makePaymet() {
		System.out.println("cash at counter");
	}

	@Override
	public void deliver() {
		System.out.println("customer pickup");
	}
}

class ProcessOnlineOrder extends OrderProcessingTemplate{

	@Override
	public void makePaymet() {
		System.out.println("debit card payment");
	}

	@Override
	public void deliver() {
		System.out.println("ship it to customer");
	}
}