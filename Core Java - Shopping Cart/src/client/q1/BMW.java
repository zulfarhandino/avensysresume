package client.q1;

public class BMW implements Car {

	@Override
	public void start() {
		System.out.println("BMW starting...");
	}

	@Override
	public void ride() {
		System.out.println("Riding a BMW car");
	}

	@Override
	public void stop() {
		System.out.println("BMW car stopping...");		
	}

	@Override
	public void playMusic() {
		System.out.println("Playing music in BMW car");		
	}

}
