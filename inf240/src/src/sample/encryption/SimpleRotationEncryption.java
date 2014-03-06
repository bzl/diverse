package src.sample.encryption;

public class SimpleRotationEncryption {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//		//1-91 (viser l=92, men 92 nullerpointer
		//		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,?! /\\:;'-*+<>\"=_()&^%$#@[]{}"; 
		//
		//
		//		String ciphertext = "1\"d1]ZB@&2m\\G&y&8QSCQC.iA{4Mykg.AH^f$'9nFpfu\\%aoi>2EC-.WE";
		//		String ciphertext2 = "1:&!dQ@LK%H\"D.u'=5B6N%qH,5Wr(ZBV;:Ga7C;tFU#8iS^YeZf.p.x+\"";
		//
		//		int wordLength = 1;
		//		int day = 83;
		//		int prevLetter = 0;
		//
		//		System.out.println(92%92);
		//		System.out.println();
		//
		//			String resultat = "";
		//			//for(int i = 0; i < ciphertext.length(); i++){
		//			for(int i = 0; i < 2; i++){
		//				int v = alphabet.indexOf(""+ciphertext2.charAt(i))+1;
		//				int k = prevLetter+(day*wordLength)+v;
		//				System.out.println(k);
		//				k = k%92;
		//				System.out.println(k);
		//				System.out.println(v);
		//				resultat = resultat+alphabet.charAt(k);
		//				prevLetter = v;
		//				/* change wordLength after each space */
		//				if (k == 66){
		//					String[] tab = resultat.split(" ");
		//					wordLength = tab[(tab.length-1)].length();
		//				}
		//			}
		//
		//				System.out.println(resultat);


		String cip1 = "PNRFNE PVCURE RE SBE YRGG. SVAA SYRER HGSBEQEVATRE CNN FVXXREURGFOYBTTRA GVY AFZ.";
		//String cip2 = "ULFC://TXBYS.AKY. FLMG.FA/GSD/QM/GGXAEVDVFSRF? ";
		//String cip3 = "32 19 1C 12 1B 57 2F 38 25 57 04 18 1A 57 13 12 03 03 12 57 12 05 57 18 11 03 12 57 15 05 02 1C 03 57 16 01 57 1A 16 1B 00 16 05 12 59 57 3C 16 19 04 1C 1D 12 57 13 02 57 12 05 57 1E 19 03 12 05 12 04 04 12 05 03 57 1E 57 16 19 16 1B 0E 04 12 57 16 01 57 1A 16 1B 00 16 05 12 48 ";




		System.out.println(13+" - "+rotation(13, cip1));
		String alpha = "A 	B 	C 	D 	E 	F 	G 	H 	I 	J 	K 	L 	M 	N 	O 	P 	Q 	R 	S 	T 	U 	V 	W 	X 	Y 	Z".replace("	", "");
		System.out.println(alpha);
		System.out.println(alpha.length());






	}

	/**
	 * 
	 * @param rot
	 * @param plaintext
	 * @return
	 */
	private static String rotation(int rot, String plaintext) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String ciphertext = "";

		for (int i = 0; i < plaintext.length(); i++) {
			int original = Character.getNumericValue(plaintext.charAt(i))-10;

			if (original == -11){
				ciphertext += " ";
			} else {
				original += rot;
				original %= 26;
				ciphertext += alphabet.charAt(original);
			}
		}
		return ciphertext;
	}

//	private static String rotationAdvanced(int rot, String cipherText) {
//		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,?! /\\:;'-*+<>\"=_()&^%$#@[]{}";
//		String plaintext = "";
//
//		for (int i = 0; i < cipherText.length(); i++) {
//
//			int original = alphabet.indexOf(""+cipherText.charAt(i));
//			original += rot;
//			original %= 92;
//			plaintext += alphabet.charAt(original);
//
//		}
//		return plaintext;
//	}


}
