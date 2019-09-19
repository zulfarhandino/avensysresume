package client.q1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChooseCar {

	public static void main(String[] args) {
		int carChoice, serviceChoice;
		String carChoiceName;
		Scanner scn = new Scanner(System.in);
		boolean selectServiceFlag = true;
		Car car;

		try {
			while(true) {
				System.out.println("Please choose a car: ");
				System.out.println("1. sMazda");
				System.out.println("2. Ferrari");
				System.out.println("3. Toyota");
				System.out.println("4. BMW");
				System.out.println();
				System.out.print("Choice: ");
				while(!scn.hasNextInt()) {
					System.out.println();
					System.out.println("Please enter a valid input");
					System.out.println();
					scn.next();
					System.out.print("Choice: ");
				}
				carChoice = scn.nextInt();
				System.out.println();

				if(carChoice == 1) {
					car = new sMazda();
					carChoiceName = "sMazda";
					break;
				}
				else if(carChoice == 2) {
					car = new Ferrari();
					carChoiceName = "Ferrari";
					break;
				}
				else if(carChoice == 3) {
					car = new Toyota();
					carChoiceName = "Toyota";
					break;
				}
				else if(carChoice == 4) {
					car = new BMW();
					carChoiceName = "BMW";
					break;
				}
				else {
					System.out.println("Please enter a valid car no.");
					System.out.println();
				}
			}
			while(selectServiceFlag) {
				System.out.println("Please choose a service no. for " + carChoiceName + ":");
				System.out.println("1. Start " + carChoiceName);
				System.out.println("2. Ride " + carChoiceName);
				System.out.println("3. Play music in " + carChoiceName);
				System.out.println("4. Stop " + carChoiceName);
				System.out.println();
				System.out.print("Choice: ");
				while(!scn.hasNextInt()) {
					System.out.println();
					System.out.println("Please enter a valid input");
					System.out.println();
					scn.next();
					System.out.print("Choice: ");
				}
				serviceChoice = scn.nextInt();
				System.out.println();

				if(serviceChoice == 1) {
					car.start();
					break;
				}
				else if(serviceChoice == 2) {
					car.ride();
					break;
				}
				else if(serviceChoice == 3) {
					car.playMusic();
					break;
				}
				else if(serviceChoice == 4) {
					car.stop();
					break;
				}
				else {
					System.out.println("Please enter a valid car no.");
					System.out.println();
				}
			}
		} catch(InputMismatchException e) {
			System.out.println();
			System.out.println("An invalid input was entered, please restart program.");
		}
	} 
}
