package design.patterns.structural;

public class Bridge {
	public static void main(String args[]) {
		TransientWindow t = new TransientWindow(new PMWindowImpl());
		t.drawCloseBox();
	}
}

abstract class WindowAbstraction{
	WindowImpl wi;
	public void drawRect() {
		wi.devdrawLine();
		wi.devdrawLine();
		wi.devdrawLine();
		wi.devdrawLine();
	}
	public void drawText() {
		wi.devDrawText();
	}
	public WindowAbstraction(WindowImpl wi) {
		this.wi = wi;
	}
}

abstract class WindowImpl{
	public abstract void devDrawText();
	public abstract void devdrawLine();
}

class IconWindow extends WindowAbstraction {

	public IconWindow(WindowImpl wi) {
		super(wi);
	}
	public void drawBorder() {
		drawRect();
		drawText();
	}
}

class TransientWindow extends WindowAbstraction {
	public TransientWindow(WindowImpl wi) {
		super(wi);
		// TODO Auto-generated constructor stub
	}

	public void drawCloseBox() {
		drawRect();
	}
}


class XWindowImpl extends WindowImpl{

	@Override
	public void devDrawText() {
		System.out.println("drawing text on Xwindow system");
	}
	@Override
	public void devdrawLine() {
		// TODO Auto-generated method stub
		System.out.println("drawing line on Xwindow system");
	}
}

class PMWindowImpl extends WindowImpl{
	@Override
	public void devDrawText() {
		System.out.println("drawing text on PMWindow system");
	}

	@Override
	public void devdrawLine() {
		System.out.println("drawing line on PMWindow system");
	}
}