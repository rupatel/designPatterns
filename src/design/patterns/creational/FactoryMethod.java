package design.patterns.creational;

public class FactoryMethod{
	public static void main(String args[]) {
		RacingApp r = new MountainRacingApp();
		r.createRace();
	}
}

//applications dont know which Race to create in advance
abstract class RacingApp{
	abstract Frame createFrame();
	abstract Wheel createWheel();

	Bicycle completeBicycle() {
		Frame frame = createFrame();
		Wheel wheel = createWheel();
		return new Bicycle(frame, wheel);
	}
	
	public void createRace() {
		Bicycle b1 = completeBicycle();
		Bicycle b2 = completeBicycle();
		Bicycle b3 = completeBicycle();
	}
}

class MountainRacingApp extends RacingApp{
	@Override
	Frame createFrame() {
		// TODO Auto-generated method stub
		return new MountainFrame();
	}

	@Override
	Wheel createWheel() {
		// TODO Auto-generated method stub
		return new MountainWheel();
	}
}

class NormalRacingApp extends RacingApp{

	@Override
	Frame createFrame() {
		// TODO Auto-generated method stub
		return new RacingFrame();
	}

	@Override
	Wheel createWheel() {
		// TODO Auto-generated method stub
		return new RacingWheel();
	}
	
}