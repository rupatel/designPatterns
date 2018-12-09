package design.patterns.creational;

public class PrototypeClient {
	public static void main(String args[]) {
		GraphicTool gt = new GraphicTool(new CatGraphicProto());
		gt.addOperation();
	}
}

class GraphicTool{
	GraphicPrototype proto;
	GraphicTool(GraphicPrototype proto){
		this.proto = proto;
	}
	public void addOperation() {
		GraphicPrototype p = proto.clone();
		p.draw();
	}
}

abstract class GraphicPrototype implements Cloneable{
	public GraphicPrototype clone() {
		Object clone = null;
		try {
			clone = super.clone();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (GraphicPrototype)clone;
	}

	public abstract void draw();
}

class CatGraphicProto extends GraphicPrototype 
{ 
	public void draw()  
    { 
       System.out.println("drawing cat graphic ...");
    } 
} 
  
class DogGraphicProto extends GraphicPrototype{
	@Override
	public void draw() {
		 System.out.println("drawing dog graphic ...");
	}
}