package client.q4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchFinally {
	
	private static Scanner scn;

	public static void main(String[] args) {
		scn = new Scanner(System.in);
		try {
		System.out.print("Please enter an integer: ");
		scn.nextInt();
		} catch(InputMismatchException e) {
			System.out.println();
			System.out.println(e + ": Invalid input entered");
		} finally {
			System.out.println();
			System.out.println("Program terminated.");
		}
	}

}
