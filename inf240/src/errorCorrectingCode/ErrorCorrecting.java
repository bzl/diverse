package errorCorrectingCode;

import java.util.Arrays;
/**
 * Example code used for university course work.
 * 
 * @author Kristoffer Tverå (Bluekristoffer@gmail.com)
 */
public class ErrorCorrecting {

	/**
	 * Performs a simple error check on 15 bit code,
	 * carrying a 11 bit message. 
	 * 
	 * Message is 11 bit, assuming at most one error, 
	 * more errors will void the programs logic.
	 * 
	 * Process is automated, utilizing a hardcoded Hamming
	 * parity check matrix, and a received vector.
	 * 
	 * @author Kristoffer Tver�
	 * @author Bluekristoffer@gmail.com
	 * @category ErrorCorrectingCode, INF240
	 */
	public static void main(String[] args) {
		int[][] hamming = new int[][]{	{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, //contains the hard coded parity check matrix
										{1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0}, 
										{0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0}, 
										{1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1}};

		int[] received = new int[]		{0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0}; //contains the received vector

		// The vast majority of the programming logic is automated beyond this point. (No interaction required)
		System.out.println("With the following Hamming code parity check matrix;");
		printMatrix2D(hamming);
		System.out.println("And the following received vector:");
		printMatrix(received);
		System.out.println("We can conclude that the following is probably the syndrome:");
		int[] syndrome = findSyndrome(hamming, received);
		int[] noErrorSample = new int[syndrome.length];
		Arrays.fill(noErrorSample, 0);
		printMatrix(syndrome);
		if(Arrays.equals(syndrome, noErrorSample)){
			System.out.println("It would appear that the code does not contain any errors at all.");			
		} else {
			System.out.print("This syndrome corresponds to a fail on the ");
			int bitFailPosition = transposeCheck(hamming, syndrome);
			if(bitFailPosition>0) {
				System.out.println((bitFailPosition+1)+"th bit. Correcting this yields the following code change");//+1 because Java is 0-oriented
				printMatrix(received);
				printChange(bitFailPosition);
				printMatrix(shiftBitOnIndex(bitFailPosition, received));
				System.out.println("We subtract last 4 bits from the 15 bit code, to obtain the 11bit message");
				printMatrix(shiftBitOnIndex(bitFailPosition, received), 11);
			} else {
				System.out.println("It appears we did not find the syndrome within the hamming parity check matrix "+
			"(check your hamming parity matrix and/or received vector ");
			}
		}
	}

	/**
	 * Dynamic help method to add a "arrow" in the print, to format the text
	 * 
	 * @param bitFailPosition position we want the "arrow" to point to.
	 */
	private static void printChange(int bitFailPosition) {
		String whitespaces = "";
		for(int i = 0; i < bitFailPosition; i++){
			whitespaces += "  ";
		}
		whitespaces += "\\ /";
		System.out.println(whitespaces);
	}

	/**
	 * Finds the syndrome based on the simple underlying logic of multiplying two vectors
	 * (dot product). We multiply the parity matrix with the vector containing the recieved
	 * code, to find the the resulting matrix.
	 * 
	 * Then we proceed to checksum all the integers of each row. IF they are even, we
	 * add a zero to the resulting new vector. If they are not even, we must add a 
	 * digit one for correct checksum(/parity bit)
	 * 
	 * @param parityCheck Parity check matrix
	 * @param vector recieved vector we suspect has 0/1 errors
	 * @return resulting "S" vector utilized to identify erroreous bit. 
	 */
	private static int[] findSyndrome(int[][] parityCheck, int[] vector) {
		int[] syndrome = new int[parityCheck.length];

		for(int i = 0; i < parityCheck.length; i++){ //Performs the multiplication of the vector and the parity matrix
			for(int j = 0; j < parityCheck[i].length; j++){
				parityCheck[i][j] *= vector[j];
			}
		}

		for(int i = 0; i < parityCheck.length; i++){//Loops through the "outer" parity matrix (performs 4 iterations with default matrix)
			int checkSum = 0;
			for(int j = 0; j < parityCheck[i].length; j++){//Loops through the "inner" parity matrix(performs 15 iterations with default matrix)
				checkSum += parityCheck[i][j];
			}
			if(checkSum%2 == 0){ //if even amount of "1" we add a zero,
				syndrome[i] = 0;
			}else{ //if uneven amount of "1", we add a "1" to balance the checksum.
				syndrome[i] = 1;
			}
		}

		return syndrome;
	}

//	/**
//	 * Deprecated(not in use) method that calculates the hammingdistance 
//	 * between two int arrays with equal length. 
//	 * E.g {1,1,1,1} and {1,1,0,0} has a hamming distance of two.
//	 * 
//	 * @param tab1 The first of two arrays to be compared
//	 * @param tab2 The second of two arrays to be compared
//	 * @return hamming distance between two arrays.
//	 */
//	private static int hammingDistance(int[] tab1, int[] tab2){
//		int distance = 0;
//		if((tab1.length != tab2.length)){
//			System.out.println("hammingDistance() was called with invalid input.");
//			return -1;
//		}
//		for(int i = 0; i < tab1.length; i++){
//			//iterate through entire first array, compare with second, increment if no match.
//			if(tab1[i] != tab2[i]){
//				distance++;
//			}
//		}
//		return distance;
//	}

	/**
	 * Checks a vector (key) with a matrix, to see if vector is present.
	 * If vector is found, returns the position where it found the vector
	 * Essentially just a search engine.
	 * 
	 * @param array the matrix we will be searching inside
	 * @param key the key we will be searching for
	 * @return the position where key is found, if not found, -1
	 */
	private static int transposeCheck(int[][] array, int[] key){
		int[][] transposedArray = transposeArray(array);

		if(array.length != key.length){
			System.out.println("transposeCheck() was called with invalid input.");
			return -1;
		}

		for(int i = 0; i < transposedArray.length; i++){
			if(Arrays.equals(transposedArray[i], key)){
				return i;
			}
		}

		return -1;
	}

	/**
	 * Retrieves the transpose of its input matrix, by reflecting the elements 
	 * over its main diagonal (topleft, botright). Basically flips it sideways.
	 * 
	 * @param array The array we want to transpose
	 * @return the new transposed array
	 */
	private static int[][] transposeArray(int[][] array){
		int[][] output = new int[array[0].length][array.length];

		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length; j++){
				output[j][i] = array[i][j];
			}
		}

		return output;
	}

	/**
	 * Prints a matrix
	 * 
	 * @param matrix the matrix beeing printed
	 */
	private static void printMatrix(int[] matrix){
		System.out.print("{");
		for(int j = 0; j < matrix.length; j++){
			String lineEnd = (j == (matrix.length-1)) ? "" : " ";
			System.out.print(matrix[j]+lineEnd);
		}
		System.out.print("}\n");

	}
	
	/**
	 * Prints a matrix up until and including the last element,
	 * defined by integer "end" in parameter.
	 * 
	 * @param matrix the matrix beeing printed
	 * @param end where we stop printing
	 */
	private static void printMatrix(int[] matrix, int end){
		System.out.print("{");
		for(int j = 0; j < end; j++){
			String lineEnd = (j == (end-1)) ? "" : " ";
			System.out.print(matrix[j]+lineEnd);
		}
		System.out.print("}\n");

	}

	/**
	 * Prints a 2D matrix
	 * 
	 * @param matrix the matrix beeing printed
	 */
	private static void printMatrix2D(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			System.out.print("{");
			for(int j = 0; j < matrix[i].length; j++){
				String lineEnd = (j == (matrix[i].length-1)) ? "" : " ";
				System.out.print(matrix[i][j]+lineEnd);
			}
			System.out.print("}\n");
		}
	}

	/**
	 * Shifts a 0|1 on a index passed in as a parameter. Used to correct a error
	 * we have found in our code.
	 * 
	 * @param index
	 * @param vector
	 * @return the new vector after shifting a bit.
	 */
	private static int[] shiftBitOnIndex(int index, int[] vector){
		int[] shiftedVector = Arrays.copyOf(vector, vector.length);

		shiftedVector[index] = (vector[index] == 0) ? 1 : 0; // if current value is 0, put 1. Else put 0. (enhanced IF statement in java)

		return shiftedVector;
	}
}
