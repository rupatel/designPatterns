package design.patterns.behavorial;

import java.util.ArrayList;
import java.util.List;

public class ObserverClient {
	public static void main(String args[]) {	
		Cricket c = new Cricket();
		ScoreBoard b = new ScoreBoard(c); 
		c.setScore(10);
	}
}

interface Observer{
	public void update();
}

interface Subject{
	public void notifyObserver();
	public void attach(Observer o);
	public void detach(Observer o);
}

class Cricket implements Subject{
	int score;
	List<Observer> obs = new ArrayList<Observer>();
	public void setScore(int score) {
		this.score = score;
		this.notifyObserver();
	}
	public int getScore() {
		return score;
	}
	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for(Observer o : obs) {
			o.update();
		}
	}

	@Override
	public void attach(Observer o) {
		// TODO Auto-generated method stub
		obs.add(o);
	}

	@Override
	public void detach(Observer o) {
		// TODO Auto-generated method stub
		obs.remove(o);
	}
}

class ScoreBoard implements Observer{
	Cricket s;
	public ScoreBoard(Cricket s) {
		this.s = s;
		s.attach(this);
	}
	public void update() {
		System.out.println("score updated" + s.getScore());
	}
}