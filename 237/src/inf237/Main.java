package inf237;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args){

		double test = 1.9230769230769231;
		double test2 = 1.56262341;

		DecimalFormat df = new DecimalFormat("#.00");

	    
	    
		System.out.printf("%.3f %.3f", test, test2);
		
		// System.out.println(System.getProperty("java.version"));
	}
}
