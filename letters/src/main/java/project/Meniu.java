package project;

import java.util.Scanner;

public class Meniu {
	private static final Scanner scanner = new Scanner(System.in);

	 public static void main( String[] args )
	    { 
		 int x;
		 do {
			 System.out.println("\n1. Normal Simulation\n2. Fool Letter Simulation\n3. Exit");
			 x = scanner.nextInt();
				 switch(x) {
				 case 1:
					 System.out.println("Give the number of days:");
					 int n = scanner.nextInt();
					 Simulation.simulationDistributeLetters(n);
					 break;
				 case 2: 
					 Simulation.simulationFoolLetter();
					 break;
				 case 3: 
					 break;
				 default:
					 System.out.println("Invalid input. Try again");
					 
				 }
		 }while(x != 3);
		 
 
	    }
}
