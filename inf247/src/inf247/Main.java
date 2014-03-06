package inf247;

import java.util.Arrays;

public class Main {

	private static String alphabet;
	private static int[][] alpha5bits;

	public static void main(String[] args) {
		// Obscenely long string :s
		String ciphertext = "28, 17, 3, 28, 17, 32, 32, 17, 10, 3, 8, 30, 10, 25, 22, 18, 19, 8, 12, 13, 28, 17, 14, 32, 8, 26, 27, 5, 3, 26, 22, 6, 31, 4, 29, 16, 5, 8, 25, 31, 26, 4, 22, 2, 11, 29, 18, 2, 13, 9, 7, 13, 15, 15, 14, 18, 30, 22, 16, 12, 19, 23, 6, 29, 31, 25, 28, 26, 18, 29, 14, 26, 2, 3, 24, 21, 24, 2, 17, 23, 9, 19, 30, 23, 23, 21, 19, 30, 11, 27, 4, 20, 2, 12, 7, 6, 15, 19, 16, 27, 5, 14, 20, 22, 4, 9, 32, 1, 25, 17, 9, 32, 19, 6, 2, 4, 18, 22, 25, 29, 21, 15, 26, 29, 1, 4, 7, 10, 1, 22, 6, 21, 26, 7, 17, 12, 15, 29, 4, 13, 14, 25, 15, 10, 19, 24, 26, 21, 3, 1, 4, 1, 31, 26, 3, 18, 10, 27, 12, 28, 29, 21, 16, 16, 7, 18, 32, 13, 18, 1, 21, 5, 17, 5, 29, 30, 23, 27, 24, 32, 23, 15, 23, 26, 28, 7, 9, 18, 17, 1, 24, 24, 4, 7, 32, 23, 2, 1, 30, 22, 3, 15, 25, 22, 5, 3, 7, 23, 7, 30, 11, 13, 20, 20, 10, 13, 24, 9, 11, 20, 20, 16, 26, 9, 30, 15, 2, 31, 5, 20, 15, 4, 11, 28, 28, 31, 14, 14, 24, 2, 11, 5, 10, 8, 23, 2, 18, 4, 19, 25, 30, 30, 23, 26, 14, 8, 20, 15, 3, 14, 4, 5, 26, 32, 7, 4, 31, 12, 20, 16, 15, 25, 6, 3, 13, 12, 2, 19, 32, 13, 27, 29, 27, 30, 27, 15, 2, 5, 5, 31, 16, 29, 20, 30, 25, 10, 13, 19, 11, 13, 28, 16, 16, 9, 19, 1, 26, 21, 8, 6, 28, 13, 30, 13, 32, 25, 6, 25, 21, 17, 22, 21, 23, 25, 20, 9, 31, 3, 12, 9, 20, 21, 7, 15, 14, 1, 25, 3, 30, 18, 1, 29, 30, 19, 20, 25, 4, 10, 26, 5, 21, 13, 17, 1, 18, 29, 30, 13, 16, 32, 15, 12, 1, 32, 16, 25, 28, 12, 31, 24, 2, 31, 24, 26, 9, 7, 11, 20, 4, 23, 24, 25, 22, 24, 28, 5, 29, 28, 17, 6, 2, 6, 4, 8, 29, 26, 13, 2, 27, 21, 19, 11, 29, 20, 29, 23, 16, 26, 19, 13, 20, 18, 5, 1, 14, 17, 16, 12, 15, 32, 17, 26, 23, 10, 1, 22, 13, 8, 1, 27, 20, 22, 17, 31, 1, 15, 25, 31, 1, 8, 10, 9, 18, 31, 6, 32, 20, 26, 17, 29, 13, 32, 19, 26, 27, 16, 4, 17, 17, 4, 12, 2, 13, 20, 21, 11, 16, 10, 11, 16, 15, 17, 19, 24, 18, 30, 20, 21, 4, 31, 5, 1, 31, 31, 29, 1, 15, 19, 1, 32, 26, 13, 3, 27, 27, 4, 22, 30, 25, 9, 27, 20, 7, 1, 24, 7, 28, 15, 28, 6, 10, 3, 3, 18, 23, 6, 7, 10, 6, 20, 7, 7, 7, 7, 13, 32, 20, 24, 17, 11, 20, 25, 12, 21, 21, 27, 12, 24, 27, 16, 32, 30, 20, 18, 5, 20, 31, 1, 8, 14, 17, 20, 19, 22, 9, 5, 5, 26, 7, 8, 18, 9, 1, 5, 21, 28, 26, 8, 14, 27, 2, 25, 23, 19, 31, 26, 12, 11, 24, 13, 23, 8, 22, 4, 6, 9, 12, 24, 4, 29, 8, 9, 8, 12, 14, 17, 17, 23, 7, 4, 14, 10, 13, 9, 18, 26, 31, 25, 22, 1, 5, 22, 27, 10, 18, 23, 13, 9, 25, 18, 10, 30, 8, 7, 7, 11, 9, 5, 12, 7, 25, 13, 7, 30, 5, 17, 22, 24, 4, 25, 7, 19, 29, 13, 25, 10, 9, 7, 29, 28, 25, 30, 18, 17, 1, 24, 5, 29, 15, 2, 13, 21, 14, 6, 1, 10, 9, 3, 15, 30, 10, 8, 15, 1, 15, 24, 17, 22, 4, 4, 21, 1, 11, 21, 29, 16, 20, 22, 4, 32, 31, 24, 21, 31, 30, 24, 1, 32, 11, 25, 9, 32, 29, 28, 11, 5, 10, 16, 22, 2, 10, 1, 31, 30, 14, 9, 17, 27, 10, 5, 26, 26, 21, 23, 3, 22, 14, 18, 25, 28, 22, 24, 23, 9, 10, 15, 5, 10, 2, 19, 32, 19, 19, 24, 2, 14, 29, 9, 31, 5, 18, 15, 20, 15, 31, 9, 27, 27, 3, 12, 6, 14, 2, 24, 6, 16, 32, 2, 16, 23, 2, 2, 18, 24, 14, 15, 26, 24, 19, 25, 5, 24, 9, 5, 30, 5, 1, 11, 14, 29, 28, 18, 10, 26, 25, 11, 6, 24, 26, 29, 10, 29, 20, 21, 20, 23, 18, 26, 27, 28, 28, 10, 14, 12, 22, 9, 3, 14, 28, 24, 28, 4, 1, 10, 27, 30, 30, 10, 14, 9, 10, 10, 30, 5, 6, 6, 29, 10, 1, 13, 2, 18, 20, 21, 27, 21, 22, 2, 28, 16, 19, 4, 1, 1, 25, 11, 22, 26, 24, 24, 15, 23, 9, 9, 15, 1, 5, 23, 25, 12, 27, 12, 23, 9, 24, 23, 29, 15, 4, 9, 20, 23, 24, 12, 18, 1, 32, 5, 7, 14, 13, 7, 7, 8, 6, 11, 26, 26, 17, 28, 26, 22, 17, 23, 3, 9, 30, 23, 30, 9, 2, 9, 5, 20, 6, 32, 4, 1, 11, 13, 22, 3, 29, 13, 13, 26, 13, 10, 16, 2, 15, 30, 17, 6, 7, 1, 19, 2, 29, 13, 1, 11, 1, 26, 3, 6, 21, 18, 18, 14, 31, 24, 17, 32, 30, 15, 11, 27, 25, 9, 17, 9, 15, 6, 3, 32, 20, 30, 11, 21, 28, 21, 7, 24, 5, 31, 26, 2, 16, 21, 3, 15, 15, 23, 1, 2, 30, 7, 10, 1, 20, 24, 12, 10, 29, 22, 25, 17, 27, 6, 31, 12, 18, 24, 12, 10, 2, 5, 32, 25, 31, 8, 8, 20, 27, 9, 1, 31, 17, 11, 9, 30, 10, 30, 23, 2, 31, 31, 31, 30, 2, 4, 5, 23, 5, 25, 7, 24, 17, 20, 21, 24, 19, 17, 29, 32, 5, 9, 19, 18, 14, 4, 26, 12, 10, 10, 9, 10, 31, 6, 12, 15, 19, 14, 14, 16, 16, 4, 11, 12, 22, 18, 22, 9, 11, 7, 1, 6, 20, 11, 23, 12, 2, 20, 29, 13, 1, 19, 26, 31, 22, 6, 8, 28, 13, 20, 22, 13, 9, 22, 13, 5, 31, 21, 19, 23, 2, 7, 6, 29, 3, 32, 18, 28, 6, 20, 23, 24, 11, 1, 32, 6, 23, 19, 16, 15, 19, 17, 8, 14, 17, 32, 20, 26, 1, 29, 9, 8, 13, 21, 6, 17, 11, 2, 31, 10, 20, 14, 32, 13, 30, 20, 10, 27, 26, 30, 10, 30, 4, 22, 30, 9, 31, 23, 2, 26, 15, 3, 29, 11, 7, 8, 14, 18, 26, 31, 9, 4, 26, 17, 26, 15, 7, 29, 27, 19, 26, 12, 15, 1, 25, 18, 11, 15, 26, 8, 26, 6, 16, 32, 2, 21, 32, 17, 18, 7, 15, 27, 28, 28, 32, 15, 29, 15, 11, 28, 30, 26, 25, 21, 4, 5, 19, 25, 5, 28, 17, 23, 22, 29, 22, 10, 14, 23, 19, 31, 12, 16, 22, 1, 10, 20, 28, 11, 28, 2, 2, 20, 28, 18, 23, 6, 24, 12, 25, 26, 1, 6, 23, 18, 19, 32, 14, 20, 9, 10, 24, 17, 31, 6, 22, 28, 25, 2";	
		String[] cipher = ciphertext.split(", ");
		String plainText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		alphabet = plainText;

		for(int i=2; i<50; i++){
			plainText = plainText+alphabet;
		}


		int[] wheel47 = new int[]{1, -1, 1, 0, -1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, -1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, -1, 0, 1, 0, 0, 0, -1, 1, 0, 1, 1};
		int[] wheel61 = new int[]{0, 1, 0, -1, -1, 0, 1, 1, 0, 1, -1, 0, -1, 0, 1, 1, -1, -1, 0, 0, 0, -1, 1, 0, 1, -1, 1, -1, 1, -1, 0, 0, 1, 0, 0, -1, 1, 0, 1, -1, 0, 0, -1, 1, 1, 1, -1, 1, -1, -1, 0, 0, 1, 0, 1, -1, -1, 0, 0, -1, -1};
		int[] wheel65 = new int[]{-1, -1, -1, 0, 1, 0, 1, 0, -1, 1, -1, -1, 0, 1, 0, 0, 1, -1, 0, 0, 0, 0, -1, 1, -1, 1, 0, -1, 1, 0, 1, 1, 1, 0, 1, -1, 0, -1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, -1, 1, -1, 1, 1, -1, 0, 0, 1, 1, 0, 0, -1, 0, -1, 0, 1};
		int[] wheel71 = new int[]{0, -1, -1, 1, 1, 1, 1, 0, 0, 1, -1, -1, 0, -1, 0, 0, -1, -1, 1, 1, 0, 0, 1, 1, 1, 1, -1, -1, 1, -1, 1, 1, 1, -1, 1, 1, 1, 1, -1, 1, 0, -1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, -1, 1, 1, 1, 0, 1, -1, -1, -1, 0, 1, 1, 0, 1, -1, 0, 0, 0};
		int[] wheel73 = new int[]{0, -1, -1, -1, 0, 1, 0, 0, -1, -1, 1, 0, -1, 0, 1, 0, 0, -1, -1, -1, 1, 1, 1, 1, -1, 1, -1, 0, 0, 1, -1, 0, 1, 1, 0, -1, 1, 0, 1, 1, 1, -1, 0, -1, 0, 1, 0, -1, 1, 1, 1, 1, -1, 0, 0, -1, -1, -1, 0, 1, -1, 0, 0, 1, 0, -1, -1, 1, -1, 1, -1, 0, 0};				

		int[] unknown1 = new int[1276];
		Arrays.fill(unknown1, -1);
		int[] unknown2 = new int[1276];
		Arrays.fill(unknown2, -1);
		int[] unknown3 = new int[1276];
		Arrays.fill(unknown3, -1);
		int[] unknown4 = new int[1276];
		Arrays.fill(unknown4, -1);
		int[] unknown5 = new int[1276];
		Arrays.fill(unknown5, -1);

		int[][] unknownWheels = new int[][]{unknown1, unknown2, unknown3, unknown4, unknown5};

		int[] tempFix = new int[]{1, 1, 1, 0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, 0, -1, -1, 1, 1, 0, 1, 0, -1, -1, -1, -1, -1, 0, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, 0, 0, -1, -1, 1, -1, -1};

		alpha5bits = new int[][]{{1, 1, 0, 0, 0}, {1, 0, 0, 1, 1}, {0, 1, 1, 1, 0}, {1, 0, 0, 1, 0}, {1, 0, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 1}, {0, 0, 1, 0, 1}, {0, 1, 1, 0, 0}, {1, 1, 0, 1, 0}, {1, 1, 1, 1, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 1, 1}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}, {0, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {1, 1, 0, 0, 1}, {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 1, 0, 1, 1}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};

		//Verified that our xor method works as intended. 
		//		System.out.println(Arrays.toString(xor(plainText.charAt(0), new int[]{0,1,0,1,0}))); //10010
		//		System.out.println(Arrays.toString(xor(plainText.charAt(1), new int[]{0,1,0,1,0}))); //11001
		//		System.out.println(Arrays.toString(xor(plainText.charAt(2), new int[]{0,1,0,1,0}))); //00100
		int teller = 0;
		for(int g = 0; g < cipher.length; g++){
			int[] firstFiveWheels = new int[]{wheel47[g%47],wheel61[g%61],wheel73[g%73],wheel71[g%71],wheel65[g%65]};
			//			if(g == 34){
			//				System.out.println(cipher[g]);
			//				System.out.println(plainText.charAt(g));
			//				System.out.println(Arrays.toString(firstFiveWheels));
			//			}

			/* Below is the logic that primarily deals with identifying machine
			 * positions in which the first five wheels are all identified, so
			 * that we can use the data from the wheels, xor the plaintext
			 * (which we know), and then compare with the ciphertext.
			 */
			boolean fullFirstFiveWheels = true;
			for (int i : firstFiveWheels) {
				if(i == -1){
					fullFirstFiveWheels = false;
					break;
				}
			}
			teller++;
			if(fullFirstFiveWheels){
				teller++;
				/*
				 * 5, 28, 31, 27 and 20 deals with baud codes of weight 1
				 */
				if(cipher[g].equals("5")){//[1, 0, 0, 0, 0]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{0,1,0,0,0})){
						unknown4[g] = 1;
						unknown5[g] = 0;
					}else if(Arrays.equals(result, new int[]{0,0,1,0,0})){
						unknown3[g] = 1;
						unknown4[g] = 0;
						unknown5[g] = 0;
					}else if(Arrays.equals(result, new int[]{0,0,0,1,0})){
						unknown2[g]	= 1;
						unknown3[g] = 0;
						unknown4[g] = 0;
						unknown5[g] = 0;
					}else if(Arrays.equals(result, new int[]{1,0,0,0,0})){
						System.out.println("bomb1");
						if(tempFix[g%53] != -1)
							System.out.println("defused");
					}
				} else if(cipher[g].equals("28")){ //[0, 1, 0, 0, 0]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{0,1,0,0,0})){//absolutt ingen endring
						unknown4[g] = 1;
						unknown5[g] = 1;
					}else if(Arrays.equals(result, new int[]{0,0,1,0,0})){
						unknown3[g] = 1;
						unknown4[g] = 0;
						unknown5[g] = 1;
					}else if(Arrays.equals(result, new int[]{0,0,0,1,0})){
						unknown2[g] = 1;
						unknown3[g] = 0;
						unknown4[g] = 0;
						unknown5[g] = 1;
					}else if(Arrays.equals(result, new int[]{0,0,0,0,1})){ //posioned
						System.out.println("bomb2");
						if(tempFix[g%53] != -1)
							System.out.println("defused");
						//						unknown1[g] = 1;
						//						unknown2[g] = 0;
						//						unknown3[g] = 0;
						//						unknown4[g] = 0;
						//						unknown5[g] = 1;
					}
				} else if(cipher[g].equals("31")){//[0, 0, 1, 0, 0]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{0,0,1,0,0})){
						unknown3[g] = 1;
						unknown4[g] = 1;
					}else if(Arrays.equals(result, new int[]{0,0,0,1,0})){
						unknown2[g] = 1;
						unknown3[g] = 0;
						unknown4[g] = 1;
					}else if(Arrays.equals(result, new int[]{0,0,0,0,1})){
						unknown1[g] = 1;
						unknown2[g] = 0;
						unknown3[g] = 0;
						unknown4[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,0,0,0,0})){
						unknown1[g] = 0;
						unknown2[g] = 0;
						unknown3[g] = 0;
						unknown4[g] = 1;
					}else if(Arrays.equals(result, new int[]{0,1,0,0,0})){
						unknown4[g] = 0;
					}
				} else if(cipher[g].equals("27")){ //[0, 0, 0, 1, 0]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{0,0,0,1,0})){
						unknown2[g] = 1;
						unknown3[g] = 1;
					}else if(Arrays.equals(result, new int[]{0,0,0,0,1})){
						unknown1[g] = 1;
						unknown2[g] = 0;
						unknown3[g] = 1;
					}else if (Arrays.equals(result, new int[]{0,0,1,0,0})){
						unknown3[g] = 0;
					}else if(Arrays.equals(result, new int[]{1,0,0,0,0})){
						unknown1[g] = 0;
						unknown2[g] = 0;
						unknown3[g] = 1;
					}
				} else if(cipher[g].equals("20")){ //[0, 0, 0, 0, 1]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{0,0,0,0,1})){
						unknown1[g] = 1;
						unknown2[g] = 1;
					}else if(Arrays.equals(result, new int[]{0,0,0,1,0})){
						unknown2[g] = 0;
					}else if(Arrays.equals(result, new int[]{1,0,0,0,0})){
						unknown1[g] = 0;
						unknown2[g] = 1;
					}
				}
				/*
				 * 22, 24, 30, 17 and 11 deals with baudcodes of weight 4
				 */
				else if(cipher[g].equals("22")){//[0, 1, 1, 1, 1]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{1,0,1,1,1})){
						unknown4[g] = 1;
						unknown5[g] = 0;
					}else if(Arrays.equals(result, new int[]{1,1,0,1,1})){
						unknown3[g] = 1;
						unknown4[g] = 0;
						unknown5[g] = 0;
					}else if(Arrays.equals(result, new int[]{1,1,1,0,1})){
						unknown2[g]	= 1;
						unknown3[g] = 0;
						unknown4[g] = 0;
						unknown5[g] = 0;
					}else if(Arrays.equals(result, new int[]{0,1,1,1,1})){
						System.out.println("bomb3");
						if(tempFix[g%53] != -1){
							if(tempFix[g%53] == 1){
								unknown1[g] = 1;
								unknown5[g] = 1;
							} else if (tempFix[g%53] == 0){
								//kan vel egentlig ikke si en drit, siden det fortsatt er to muligheter, ingen ting er ekskludert
							}
						}
					}
				} else if(cipher[g].equals("24")){ //[1, 0, 1, 1, 1]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{1,0,1,1,1})){//absolutt ingen endring
						unknown4[g] = 1;
						unknown5[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,1,0,1,1})){
						unknown3[g] = 1;
						unknown4[g] = 0;
						unknown5[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,1,1,0,1})){
						unknown2[g] = 1;
						unknown3[g] = 0;
						unknown4[g] = 0;
						unknown5[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,1,1,1,0})){ //posioned
						System.out.println("bomb4");
						if(tempFix[g%53] != -1){
							if(tempFix[g%53] == 1){
								unknown1[g] = 0;
								unknown5[g] = 0;
							} else if (tempFix[g%53] == 0){
								unknown1[g] = 1;
								unknown2[g] = 0;
								unknown3[g] = 0;
								unknown4[g] = 0;
								unknown5[g] = 1;
							}
						}
						//						unknown1[g] = 1;
						//						unknown2[g] = 0;
						//						unknown3[g] = 0;
						//						unknown4[g] = 0;
						//						unknown5[g] = 1;
					}
				} else if(cipher[g].equals("30")){//[1, 1, 0, 1, 1]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{1,1,0,1,1})){
						unknown3[g] = 1;
						unknown4[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,1,1,0,1})){
						unknown2[g] = 1;
						unknown3[g] = 0;
						unknown4[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,1,1,1,0})){
						unknown1[g] = 1;
						unknown2[g] = 0;
						unknown3[g] = 0;
						unknown4[g] = 1;
					}else if(Arrays.equals(result, new int[]{0,1,1,1,1})){
						unknown1[g] = 0;
						unknown2[g] = 0;
						unknown3[g] = 0;
						unknown4[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,0,1,1,1})){
						unknown4[g] = 0;
					}
				} else if(cipher[g].equals("17")){ //[1, 1, 1, 0, 1]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{1,1,1,0,1})){
						unknown2[g] = 1;
						unknown3[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,1,1,1,0})){
						unknown1[g] = 1;
						unknown2[g] = 0;
						unknown3[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,1,0,1,1})){
						unknown3[g] = 0;
					}else if(Arrays.equals(result, new int[]{0,1,1,1,1})){
						unknown1[g] = 0;
						unknown2[g] = 0;
						unknown3[g] = 1;
					}
				} else if(cipher[g].equals("11")){ //[1, 1, 1, 1, 0]
					int[] result = xor(plainText.charAt(g), firstFiveWheels);
					if(Arrays.equals(result, new int[]{1,1,1,1,0})){
						unknown1[g] = 1;
						unknown2[g] = 1;
					}else if(Arrays.equals(result, new int[]{1,1,1,0,1})){
						unknown2[g] = 0;
					}else if(Arrays.equals(result, new int[]{0,1,1,1,1})){
						unknown1[g] = 0;
						unknown2[g] = 1;
					}
				}
			}
		}
		//		System.out.println(teller);

		int[] wheelSizes = new int[]{53,59,64,67,69}; //the different positions the wheel can take on.

		//copy pasta koden nedefra dirr fra first5wh, den er disfunk som faaaaan
		for(int k = 0; k<unknownWheels.length; k++){ //Iterate through all the 5 unknown wheels we have
			for(int i = 0; i<wheelSizes.length; i++){ //Iterates through the 10 possible sizes our wheel can have.
				int[] wheel = new int[wheelSizes[i]];
				Arrays.fill(wheel, -1);
				int collision = 0;
				for(int j = 0; j < cipher.length; j++){ //Iterate through the entire ciphers worth of length

					int wj = j%wheel.length;

					int currentUnknown = unknownWheels[k][j];

					if(currentUnknown != -1){

						if((wheel[wj] == 1 || wheel[wj] == 0) && wheel[wj] != currentUnknown){
							collision++;
							break;
						} else{
							wheel[wj] = currentUnknown;
						}
					}
				}


				if(collision == 0){
					System.out.println("Wheel "+k+" can have size "+wheelSizes[i]);
					//break;
				}
			}
		}

		//		for (int j = 0; j < unknownWheels.length; j++) { //Iterates through all the actual wheels >0-4
		//			for (int k = 0; k < wheelSizes.length; k++) { //Iterates through all wheel sizes >0-9
		//				int collisions = 0;
		//				int currentWheelSize = wheelSizes[k];
		//				int[] wheel = new int[currentWheelSize];
		//				Arrays.fill(wheel, -1);
		//
		//				for (int l = 0; l < unknownWheels[j].length; l++) {
		//					if (wheel[l % currentWheelSize] != unknownWheels[j][l]) {
		//						if(wheel[l % currentWheelSize] == -1){
		//							wheel[l % currentWheelSize] = unknownWheels[j][l];
		//						} else {
		//							collisions++;
		//						}
		//					}
		//				}
		//
		//				if(collisions == 0){
		//					System.out.println("Unknown wheel "+j+" had +"+collisions+"+ collisions with size "+ currentWheelSize);
		//					System.out.println(Arrays.toString(wheel));
		//				} else {
		//					System.out.println("Unknown wheel "+j+" had +"+collisions+"+ collisions with size "+ currentWheelSize);
		//				}
		//			}
		//		}
	}

	private static int[] xor(char bokstav, int[] firstFiveWheels) {
		int pos = alphabet.indexOf(bokstav);
		int[] returnArray = new int[5];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = firstFiveWheels[i]^alpha5bits[pos][i];
		}
		return returnArray;
	}

}

