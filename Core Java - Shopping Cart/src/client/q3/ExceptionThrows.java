package client.q3;

public class ExceptionThrows {

	static void arrayException() throws ArrayIndexOutOfBoundsException{
		char[] charArray = "exceptions".toCharArray();
		for(int i=0; i<charArray.length + 10; i++) {
			System.out.println(charArray[i]);
			if(i > charArray.length) {
				throw new ArrayIndexOutOfBoundsException("An error has occured");
			}
		}
	}

}
