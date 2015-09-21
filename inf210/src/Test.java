/**
 * Example code used for university course work.
 * 
 * @author Kristoffer Tverå (Bluekristoffer@gmail.com)
 */

public class Test {
	
	/*
	 * A logical "dice", with biased outcome.
	 */
	public static void main(String[] args) {

	
//	int a = 1;
//	int b = 0; 
//	int c = 0;
	
//	if(a==b && b == c && c == 1) System.out.println(1);
//	if(a==b && b == c && c == 0) System.out.println(2);
//	if(a==b && (b^c) == 1) System.out.println(3);
//	if(a==c && (b^c) == 1) System.out.println(4);
//	if(b==c && (a^c) == 1 && b == 0) System.out.println(5);
//	if(b==c && (a^c) == 1 && b == 1) System.out.println(6);
	
	for (int a = 0; a < 2; a++) {
		for (int b = 0; b < 2; b++) {
			for (int c = 0; c < 2; c++) {
				if(a==b && b == c && c == 1) System.out.println(1);
				if(a==b && b == c && c == 0) System.out.println(2);
				if(a==b && (b^c) == 1) System.out.println(3);
				if(a==c && (b^c) == 1) System.out.println(4);
				if(b==c && (a^c) == 1 && b == 0) System.out.println(5);
				if(b==c && (a^c) == 1 && b == 1) System.out.println(6);
			}
		}
	}
	
	}

}
