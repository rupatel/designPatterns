package design.patterns.behavorial;

public class IteratorClient {
	public static void main(String args[]) {
		Collection c1 = new  NotificaitonCollection();
		Collection c2 = new CandyCollection();
		c1.addItem(new Notification("m1"));
		c1.addItem(new Notification("m2"));
		c1.addItem(new Notification("m3"));
		c2.addItem(new Candy("c1"));
		c2.addItem(new Candy("c2"));
		c2.addItem(new Candy("c3"));
		c2.addItem(new Candy("c4"));
		
		Iterator i = c1.createIterator();
		while(i.hasNext()) {
			System.out.println((Notification)i.getNext());
		}
		
		i = c2.createIterator();
		while(i.hasNext()) {
			System.out.println((Candy)i.getNext());
		}
	}
}

class Notification{
	private String message;
	public Notification(String m) {
		this.message = m;
	}
	public String toString() {
		return message;
	}
}
class Candy{
	private String name;
	public Candy(String n) {
		this.name = n;
	}
	public String toString() {
		return name;
	}
}

interface Collection{
	public abstract Iterator createIterator();
	public abstract void addItem(Object o);
}

interface Iterator{
	public boolean hasNext();
	public Object getNext();
}

class NotificationIterator implements Iterator{
	public NotificaitonCollection lst;
	int i = 0;
	public NotificationIterator(NotificaitonCollection lst) {
		this.lst = lst;
	}
	@Override
	public boolean hasNext() {
		return i < lst.size();
	}

	@Override
	public Object getNext() {
		return lst.get(i++);
	}
	
}

class CandyIterator implements Iterator{
	public CandyCollection lst;
	int i = 0;
	public CandyIterator(CandyCollection lst) {
		this.lst = lst;
	}
	@Override
	public boolean hasNext() {
		return i < lst.size();
	}

	@Override
	public Object getNext() {
		return lst.get(i++);
	}
	
}
class NotificaitonCollection implements Collection{
	Notification[] lst = new Notification[10];
	int i;
	public void addItem(Object n) {
		if(i< lst.length)
			lst[i++] = (Notification) n;
		else System.out.println("overflow ...");
	}
	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new NotificationIterator(this);
	}
	public int size() {
		return i;
	}
	public Notification get(int i) {
		return lst[i];
	}
}
class CandyCollection implements Collection{
	private Candy[] lst = new Candy[10];
	int i;
	public void addItem(Object n) {
		if(i< lst.length)
			lst[i++] = (Candy) n;
		else System.out.println("overflow ...");
	}
	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new CandyIterator(this);
	}
	public int size() {
		return i;
	}
	
	public Candy get(int i) {
		return lst[i];
	}
}