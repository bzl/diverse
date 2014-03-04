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
	
	System.out.println(nextStateFunction.length);

	}

}
