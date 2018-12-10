package design.patterns.behavorial;

public class MediatorClient {
	public static void main(String args[]) {
		Flight f = new Flight();
		Runway r = new Runway();
		ATCMediator mediator = new ATCMediator(f, r);
		f.land();
		f.setLandingRequest(true);
		r.setReady(true);
		r.setReady(false);
		r.setReady(true);
		f.setLandingRequest(true);
	}
}

interface Mediator{
	public void statusChanged(Colleague c);
}
class ATCMediator implements Mediator{
	Flight f;
	Runway r;
	public ATCMediator(Flight f, Runway r) {
		this.f = f;
		this.r = r;
		f.setMediator(this);
		r.setMediator(this);
	}
	@Override
	public void statusChanged(Colleague c) {
		if(c == f)
		{
			if(f.isLandingRequest())
				if (r.isReady()) 
					f.land(); 
				else 
					f.delayLanding();
		}
		else if(c == r) {
			if(!r.isReady() && f.isLanding())
				f.abortLanding();
		}
	}
}

abstract class  Colleague{
	Mediator mediator;
	public void changed() {
		mediator.statusChanged(this);
	}
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}

class Flight extends Colleague{
	private boolean isLanding;
	private boolean isLandingRequest;
	public boolean isLanding() {
		return isLanding;
	}
	public void delayLanding() {
		System.out.println("delaying landing....");
	}
	public void land() {
		isLanding = true;
		System.out.println("landing ...");
	}
	public void abortLanding() {
		isLanding = false;
		System.out.println("aborting landing ...");
	}
	public void setLanding(boolean isLanding) {
		this.isLanding = isLanding;
		this.changed();
	}
	public boolean isLandingRequest() {
		return isLandingRequest;
	}
	public void setLandingRequest(boolean isLandingRequest) {
		this.isLandingRequest = isLandingRequest;
		this.changed();
	}
	
}
class Runway extends Colleague{
	private boolean isReady;

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
		this.changed();
	}
}