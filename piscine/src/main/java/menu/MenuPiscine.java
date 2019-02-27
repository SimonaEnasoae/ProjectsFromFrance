package menu;

import java.io.*;

import util.ScannerInt;
/**
 * Class MenuPiscine
 * 
 * @author Simona Enasoae, Marcel Fernandez de la Pena 
 *
 */

public class MenuPiscine {
	
	public static void main( String[] args ){		
			SwimmingPool pool = new SwimmingPool(10,10);
			showMeniu(pool);
	}
	/**
	 * 
	 * @param pool the swimming pool 
	 */
	public static void showMeniu(SwimmingPool pool) {
		System.out.println("-------PISCINE-------");
		int op = 0;
		do {
			System.out.println(" \n1)Register User\n2)Run Piscine\n3)Exit");
			op = ScannerInt.readInt("");
			switch(op) {
				case 1:
				try {
					pool.registerSwimmer();
				} catch (IOException e) {
				}
					break;
				case 2:
					pool.execute();					
					break;
				case 3:
					break;
				default:
					break;
			}
			
		}while(op != 3);
	}
	
	

}
