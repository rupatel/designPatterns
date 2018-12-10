package design.patterns.behavorial;

public class StateClient {
	public static void main(String args[]) {
		MobileContext mc = new  MobileContext(new SilentState());
		mc.handleCall();
		mc.setState(new VibrateState());
		mc.handleCall();
	}
}

class MobileContext{
	private State s;
	
	public void setState(State s) {
		this.s = s;
	}
	public MobileContext(State s) {
		this.s = s;
	}
	public void handleCall() {
		s.handleState();
	}
}

abstract class State {
	public abstract void handleState();
}

class SilentState extends State {
	@Override
	public void handleState() {
		// TODO Auto-generated method stub
		System.out.println("only lit mobile no noise ...");
	}
}

class VibrateState extends State{
	@Override
	public void handleState() {
		// TODO Auto-generated method stub
		System.out.println("vibrate mobile");
	}
}