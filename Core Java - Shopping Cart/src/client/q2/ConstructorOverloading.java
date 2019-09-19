package client.q2;

public class ConstructorOverloading {
	public int i;
	public String str;
	
	public ConstructorOverloading(int i, String str) {
		this.i = i;
		this.str = str;
		this.display();
	}
	
	public ConstructorOverloading(int i) {
		this(i, "default");
		this.i = i;
	}
	
	public ConstructorOverloading() {
		this(0, "default");
	}
	
	public void display() {
		System.out.println(i + str);
	}
	
	public void display(String str2) {
		System.out.println(i + str + str2);
	}
}
