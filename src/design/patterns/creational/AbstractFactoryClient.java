package design.patterns.creational;

public class AbstractFactoryClient {
	public void createRace(BicycleFactory bicycleFactory) {
		RaceApp b1 = new RaceApp(new MountainBicycleFactory());
		b1.createRace();
	}
}

//client
class RaceApp{
	BicycleFactory bf;
	public RaceApp(BicycleFactory bf) {
		this.bf = bf;
	}
	public void createRace() {
		Bicycle b1 = bf.createBicycle();
		Bicycle b2 = bf.createBicycle();
		Bicycle b3 = bf.createBicycle();
	}
}
class Bicycle{
	Frame f;
	Wheel w;
	public Bicycle(Frame f, Wheel w) {
		this.f = f;
		this.w = w;
	}
}
abstract class BicycleFactory{
	public abstract Frame createFrame();
	public abstract Wheel createWheel();
	public Bicycle createBicycle() {
		return new Bicycle(createFrame(), createWheel());
	}
}
class RacingBicycleFactoy extends BicycleFactory{

	@Override
	public Frame createFrame() {
		return new RacingFrame();
	}

	@Override
	public Wheel createWheel() {
		return new RacingWheel();
	}
}

class MountainBicycleFactory extends BicycleFactory{

	@Override
	public Frame createFrame() {
		return new MountainFrame();
	}

	@Override
	public Wheel createWheel() {
		return new MountainWheel();
	}
}

abstract class Frame{
	public abstract String getColor();
}
class RacingFrame extends Frame{
	public String getColor() {
		return "black";
	}
}
class MountainFrame extends Frame{
	public String getColor() {
		return "black";
	}
}

abstract class Wheel{
	public abstract Integer getRadius();
}

class RacingWheel extends Wheel{
	public Integer getRadius() {
		return 10;
	}
}
class MountainWheel extends Wheel{
	public Integer getRadius() {
		return 20;
	}
}