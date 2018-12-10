package design.patterns.structural;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class DecoratorClient{
	public static void main(String args[]) {
		SupremePizza sp = new SupremePizza();
		Pizza p = new PaneerToppingDecorator(new TomatoToppingDecorator(sp));
		System.out.println(p.getIngrediants());
		System.out.println(p.getPrice());
	}
}
abstract class Pizza {
	public abstract String getName();
	public abstract int getPrice();
	public abstract List<String> getIngrediants();
}

class CheesePizza extends Pizza{

	@Override
	public String getName() {
		return "cheese pizza";
	}

	@Override
	public int getPrice() {
		return 10;
	}

	@Override
	public List<String> getIngrediants() {
		return Arrays.asList(new String[] {"marinara sauce","cheese"});
	}
}

class SupremePizza extends Pizza{

	@Override
	public String getName() {
		return "SupremePizza";
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 15;
	}

	@Override
	public List<String> getIngrediants() {
		return Arrays.asList(new String[] {"marinara sauce","cheese","mushroom","onion","bell peppers"});
	}
}

abstract class Decorator extends Pizza{
	protected Pizza pizza;
	public Decorator(Pizza p) {
		this.pizza = p;
	}
}

class TomatoToppingDecorator extends Decorator{

	public TomatoToppingDecorator(Pizza p) {
		super(p);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return pizza.getPrice() + 1;
	}

	@Override
	public List<String> getIngrediants() {
		// TODO Auto-generated method stub
		List<String> t = new ArrayList();
		t.addAll(pizza.getIngrediants());
		t.add("tomato");
		return t;
	}
}

class PaneerToppingDecorator extends Decorator{

	public PaneerToppingDecorator(Pizza p) {
		super(p);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return pizza.getPrice() + 5;
	}

	@Override
	public List<String> getIngrediants() {
		// TODO Auto-generated method stub
		List<String> t = new ArrayList();
		t.addAll(pizza.getIngrediants());
		t.add("paneer");
		return t;
	}
}