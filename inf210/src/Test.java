public class Test {

	public static void main(String[] args) {
	String[][] nextStateFunction = new String[][]{ // current state, input, resulting state, resulting "print"
			{"0","00","0","0"},
			{"0","10","1","1"},
			{"0","01","1","1"},
			{"0","11","2","0"},
			
			{"1","00","0","0"},
			{"1","10","1","1"},
			{"1","01","1","1"},
			{"1","11","2","0"},
			
			{"2","00","1","1"},
			{"2","10","2","0"},
			{"2","01","2","0"},
			{"2","11","3","1"},
			
			{"3","00","1","1"},
			{"3","10","2","0"},
			{"3","01","2","0"},
			{"3","11","3","1"}};
	

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
