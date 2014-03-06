package src.verySimple;

public class Modulo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		outerLoop:// Decleared to help us skip out of the nested loop
			for(int i = 0; i < 20; i++){//20 is a value that can be arbitrarily high.
				for (int j = 0; j < 4; j++) {// 4 should really be "8", our "magic value" presented in the pre conditions
					System.out.print("Column: "+j+", row "+i+"\t"+((j==3) ? "\n" : ""));
					/* ((j==7) ? "\n" : "") is a fancy way in java of saying, if j is 7, add \n (newline). If not, empty string on the end.
					 * Here you create object with data, column and row*/
					if(i==4 && j==3){//under any given circumstance placed in IF statement, we break the entire thing.
						break outerLoop; 
					}
				}
			}

	}
}
	