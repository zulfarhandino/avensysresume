package client.q1;

public class Toyota implements Car {

	@Override
	public void start() {
		System.out.println("Toyota starting...");
	}

	@Override
	public void ride() {
		System.out.println("Riding a Toyota car");
	}

	@Override
	public void stop() {
		System.out.println("Toyota car stopping...");		
	}

	@Override
	public void playMusic() {
		System.out.println("Playing music in Toyota car");		
	}

}
