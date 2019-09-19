package client.q1;

public class sMazda implements Car {

	@Override
	public void start() {
		System.out.println("sMazda starting...");
	}

	@Override
	public void ride() {
		System.out.println("Riding a sMazda car");
	}

	@Override
	public void stop() {
		System.out.println("sMazda car stopping...");		
	}

	@Override
	public void playMusic() {
		System.out.println("Playing music in sMazda car");		
	}

}
