package design.patterns.creational;

public class Singleton {

}
class EagerInitialization{
	private static final EagerInitialization instance = new EagerInitialization();
	private EagerInitialization() {
	}
	public static EagerInitialization getInstance() {
		return instance;
	}
}

//exception handling
class StaticBlockInitialization
{
	private static StaticBlockInitialization instance;
	private StaticBlockInitialization() {
	}
	static {
		try {
			instance = new StaticBlockInitialization();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static StaticBlockInitialization getInstance() {
		return instance;
	}
}

class LazyInitialization{
	private static LazyInitialization instance;
	private LazyInitialization() {
	}
	public static LazyInitialization getInstance() {
		if(instance == null)
			return instance = new LazyInitialization();
		return instance;
	}
}
class ThreadSafe {
	private static ThreadSafe instance;
	
	private ThreadSafe() {
	}
	public static synchronized ThreadSafe getInstance() {
		if(instance == null)
			return instance = new ThreadSafe();
		return instance;
	}
}


class DoubleCheckedLocking {
	private static DoubleCheckedLocking instance;
	
	private DoubleCheckedLocking() {
	}
	public static synchronized DoubleCheckedLocking getInstance() {
		if(instance == null) {
			synchronized(DoubleCheckedLocking.class) {
					if(instance == null) {
						instance = new DoubleCheckedLocking();  
					}
			}
		}
		return instance;
	}
}

class BillPughSingleton{
	private static BillPughSingleton instance;
	
	private BillPughSingleton() {
	}
	static class SingletonHelper {
		public static final BillPughSingleton instance = new BillPughSingleton();
	}
	public BillPughSingleton getInstance() {
		return SingletonHelper.instance;
	}
}


enum EnumSingleton{
	INSTANCE;
	public void doSomething() {
		
	}
}