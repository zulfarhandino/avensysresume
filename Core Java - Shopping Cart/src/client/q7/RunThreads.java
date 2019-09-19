package client.q7;

public class RunThreads {
	
	public static void main(String[] args) {
		
		// Implements Runnable
		RunnableThread rt1 = new RunnableThread();
		RunnableThread rt2 = new RunnableThread();
		RunnableThread rt3 = new RunnableThread();

		rt1.run();
		rt2.run();
		rt3.run();

		// Inherits Thread
		InheritedThread it1 = new InheritedThread();
		InheritedThread it2 = new InheritedThread();
		InheritedThread it3 = new InheritedThread();

		it1.run();
		it2.run();
		it3.run();
	}

}
