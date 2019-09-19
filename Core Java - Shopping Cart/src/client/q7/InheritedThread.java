package client.q7;

public class InheritedThread extends Thread {
	
	Thread t;
	
	InheritedThread() {
		t = new Thread();
		t.start();
	}

	@Override
	public void run() {
		System.out.println("InheritedThread thread " + t.getId() + " running");
	}
	
}
