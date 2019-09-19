package client.q1;

public class Ferrari implements Car {

	@Override
	public void start() {
		System.out.println("Ferrari starting...");
	}

	@Override
	public void ride() {
		System.out.println("Riding a Ferrari car");
	}

	@Override
	public void stop() {
		System.out.println("Ferrari car stopping...");		
	}

	@Override
	public void playMusic() {
		System.out.println("Playing music in Ferrari car");		
	}

}
