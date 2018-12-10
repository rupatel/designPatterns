package design.patterns.structural;

public class Adaptor {
	public static void main(String args[]) {
		DrawingEditor de = new DrawingEditor();
		de.draw(new TextShape());
	}
}

interface Shape{
	public void boundingBox();
	public void createManipulator();
}

class DrawingEditor{
	public void draw(Shape s) {
		s.boundingBox();
		s.createManipulator();
		System.out.println("drawing shape.....");
	}
}

class Line implements Shape{

	@Override
	public void boundingBox() {
		System.out.println("bounding box for line");
	}

	@Override
	public void createManipulator() {
		System.out.println("manipulator for line");
	}
}

class TextShape implements Shape{
	TextView tv = new TextView();
	@Override
	public void boundingBox() {
		tv.getExtent();
		System.out.println("bounding box for text using TextView");
	}

	@Override
	public void createManipulator() {
		tv.manupulate();
		System.out.println("manipulator for TextShame using TextView");
	}
}

class TextView{
	public void getExtent() {
		System.out.println("extended TextView");
	}
	public void manupulate() {
		System.out.println("extended TextView");
	}
}