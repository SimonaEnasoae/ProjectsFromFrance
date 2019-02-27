package util;

import java.util.*;
import java.util.logging.Logger;
import java.util.regex.*;

public class ScannerInt {
	private static final Scanner scanner = new Scanner(System.in);
	public static Logger logger = Logger.getLogger("");
	/**
	 * read an integer 
	 * input is repeated as long as it is not correct
	 * @param str -the message to be print
	 * @return the valid read input 
	 */
	public static int readInt(String str) {
		int input = -1;
		
		while (input <=0 ) {
			System.out.println(str);
			try {
				input = scanner.nextInt();
			} catch (InputMismatchException	 e){
				// consume the input (that is not an integer)
				scanner.skip(".*");
			}
			
		} 
		return input;
	}
}
