package design.patterns.behavorial;

public class CommandClient {
	public static void main(String args[]) {
		ButtonInvoker b = new ButtonInvoker(new LightOnCommand(new LightReceiver()));
		b.click();
	}
}

class ButtonInvoker{
	Command command;
	public ButtonInvoker(Command c) {
		this.command = c;
	}
	public void click() {
		command.exec();
	}
}
class LightReceiver{
	public void on() {
		System.out.println("switch on the lights");
	}
	public void off() {
		System.out.println("switch off the lights");
	}
}

interface Command{
	public void exec();
}

class LightOnCommand implements Command{
	LightReceiver light;
	public LightOnCommand(LightReceiver light) {
		this.light = light;
	}
	@Override
	public void exec() {
		light.on();
	}
}

class LightOffCommand implements Command{
	LightReceiver light;
	public LightOffCommand(LightReceiver light) {
		this.light = light;
	}
	@Override
	public void exec() {
		light.off();
	}
}