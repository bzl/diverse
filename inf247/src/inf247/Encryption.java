package inf247;

import java.util.ArrayList;
import java.util.Arrays;

public class Encryption {


	public static void main(String[] args) {

		// Obscenely long string :s
		String plainText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//int[] ciphertext = encrypt(plainText, 1276, new int[]{0,3,9,8,5,7,2,4,1,6});
		int[] ciphertext = encrypt(plainText, 0, new int[]{0,3,9,8,5,7,2,4,1,6});

		System.out.print("Cipertext is ");
		for (int i : ciphertext) {
			System.out.print(i+", ");
		}
		System.out.println("complete.");
	}

	/**
	 * Encrypts a string using the Geheimschreiber algorithm
	 * @param js 
	 * 
	 * @param String String to be encrypted.
	 * @param Int starting position of the wheels. 
	 * @param Int[] The cable permutation
	 * @return the encrypted string
	 */
	private static int[]encrypt(String plaintext, int wheelPosition, int[] cablePermutation) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int[] returnable = new int[plaintext.length()];

		int[] wheel47 = new int[]{1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1};
		int[] wheel61 = new int[]{0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1};
		int[] wheel73 = new int[]{0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0};				
		int[] wheel71 = new int[]{0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
		int[] wheel65 = new int[]{0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1};

		int[] wheel69 = new int[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1};
		int[] wheel59 = new int[]{0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1};
		int[] wheel64 = new int[]{1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1};				
		int[] wheel53 = new int[]{1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0};
		int[] wheel67 = new int[]{1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0};
		ArrayList<int[]> wheels = new ArrayList<>();
		wheels.add(wheel47);
		wheels.add(wheel53);
		wheels.add(wheel59);
		wheels.add(wheel61);
		wheels.add(wheel64);
		wheels.add(wheel65);
		wheels.add(wheel67);
		wheels.add(wheel69);
		wheels.add(wheel71);
		wheels.add(wheel73);

		int[][] alpha_to_bits = new int[][]{{1, 1, 0, 0, 0}, {1, 0, 0, 1, 1}, {0, 1, 1, 1, 0}, {1, 0, 0, 1, 0}, {1, 0, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 1}, {0, 0, 1, 0, 1}, {0, 1, 1, 0, 0}, {1, 1, 0, 1, 0}, {1, 1, 1, 1, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 1, 1}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}, {0, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {1, 1, 0, 0, 1}, {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 1, 0, 1, 1}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};

		for(int i = 0; i<plaintext.length(); i++){

			int[] currentPlainText = alpha_to_bits[alphabet.indexOf(plaintext.charAt(i))];

			int first = wheels.get(cablePermutation[0])[i%wheels.get(cablePermutation[0]).length];
			int second = wheels.get(cablePermutation[1])[i%wheels.get(cablePermutation[1]).length];
			int third = wheels.get(cablePermutation[2])[i%wheels.get(cablePermutation[2]).length];
			int fourth = wheels.get(cablePermutation[3])[i%wheels.get(cablePermutation[3]).length];
			int fifth = wheels.get(cablePermutation[4])[i%wheels.get(cablePermutation[4]).length];
			int[] firstFiveWheels = new int[]{first,second,third,fourth,fifth};

			int six = wheels.get(cablePermutation[5])[i%wheels.get(cablePermutation[5]).length];
			int seven = wheels.get(cablePermutation[6])[i%wheels.get(cablePermutation[6]).length];
			int eight = wheels.get(cablePermutation[7])[i%wheels.get(cablePermutation[7]).length];
			int nine = wheels.get(cablePermutation[8])[i%wheels.get(cablePermutation[8]).length];
			int ten = wheels.get(cablePermutation[9])[i%wheels.get(cablePermutation[9]).length];


			// Performs the XOR mechanic
			for (int j = 0; j < currentPlainText.length; j++) {
				currentPlainText[j] = firstFiveWheels[j]^currentPlainText[j];
			}

			// Performs the Switch mechanic
			if(six == 0){
				int temp = currentPlainText[0]; 
				currentPlainText[0] = currentPlainText[4]; 
				currentPlainText[4] = temp;
			}
			if(seven == 0){
				int temp = currentPlainText[4]; 
				currentPlainText[4] = currentPlainText[3]; 
				currentPlainText[3] = temp;
			}
			if(eight == 0){
				int temp = currentPlainText[3]; 
				currentPlainText[3] = currentPlainText[2]; 
				currentPlainText[2] = temp;
			}
			if(nine == 0){
				int temp = currentPlainText[2]; 
				currentPlainText[2] = currentPlainText[1]; 
				currentPlainText[1] = temp;
			}
			if(ten == 0){
				int temp = currentPlainText[1]; 
				currentPlainText[1] = currentPlainText[0]; 
				currentPlainText[0] = temp;
			}

			for(int k = 0; k < alpha_to_bits.length; k++){
				if(Arrays.equals(alpha_to_bits[k], currentPlainText))
					returnable[i] = k+1;
				if(i == 9 && k == 9){
					System.out.println(Arrays.toString(alpha_to_bits[k]));
					System.out.println(Arrays.toString(currentPlainText));
					System.out.println();
				}
			}
			
			if(i == 9){
				System.out.println(Arrays.toString(alpha_to_bits[alphabet.indexOf(plaintext.charAt(i))]));
				System.out.println(Arrays.toString(firstFiveWheels));
				System.out.println(six+", "+seven+", "+eight+", "+nine+", "+ten);
				System.out.println(Arrays.toString(currentPlainText));
				System.out.println(returnable[i]);
			}
			
			
		}

		return returnable;
	}
}