package src.sample.encryption;
/**
 * Example code used for university course work.
 * 
 * @author Kristoffer Tverå (Bluekristoffer@gmail.com)
 */
public class Vigenere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String plaintext = "ATTACKATDAWN";
		String keyword = "LEMON";

		System.out.println(vigshift(keyword, plaintext));
	}

	private static String vigshift(String keyword, String plaintext) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String ciphertext = "";
		int[] shiftSequence = new int[keyword.length()];

		for (int i = 0; i < shiftSequence.length; i++) {
			shiftSequence[i] = Character.getNumericValue(keyword.charAt(i))-10;
		}


		for (int i = 0; i < plaintext.length(); i++) {
			int original = Character.getNumericValue(plaintext.charAt(i))-10;

			if (original == -11){
				ciphertext += " ";
			} else {
				original += shiftSequence[i%(shiftSequence.length)];
				original %= 26;
				ciphertext += alphabet.charAt(original);
			}
		}
		return ciphertext;
	}
}
