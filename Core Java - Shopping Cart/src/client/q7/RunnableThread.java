package client.q7;

public class RunnableThread implements Runnable {

	Thread t;
	
	RunnableThread() {
		t = new Thread();
		t.run();
	}
	
	@Override
	public void run() {
		System.out.println("Runnable thread " + t.getId() + " running");
	}

	
}
