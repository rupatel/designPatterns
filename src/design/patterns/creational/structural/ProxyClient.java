package design.patterns.creational.structural;

public class ProxyClient {
	public static void main(String args[]) {
		ImageProxy ip = new ImageProxy();
		ip.draw();
	}
}

abstract class Graphic{
	public abstract void draw();
}

class ImageProxy extends Graphic{
	Image i;
	@Override
	public void draw() {
		loadImage();
		i.draw();
	}
	public void loadImage() {
		System.out.println("loading image...");
		this.i = new Image();
	}
}

class Image extends Graphic{
	@Override
	public void draw() {
		System.out.println("drawing image...");
	}
}