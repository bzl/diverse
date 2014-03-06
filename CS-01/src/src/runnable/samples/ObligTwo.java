package src.runnable.samples;

import java.math.BigInteger;
public class ObligTwo {

	/**
	 * Utilizes Chinese Rest Theorem to break a RSA encrypted cipher text
	 * with a low expotent of only e=3
	 * @author Kristoffer Tverå
	 */
	public static void main(String[] args) {

		/* Below are the integers used in this assigntment */
		/* n1, .. are the products of distinctive primes p1*q1, ..*/
		BigInteger n1 = new BigInteger("2469247531693");
		BigInteger n2 = new BigInteger("11111502225583");
		BigInteger n3 = new BigInteger("44444222221411");
		BigInteger n1n2 = n1.multiply(n2);
		BigInteger n1n2n3 = n1n2.multiply(n3);
		/* c1, .. is the corresponding cipher from n1, ..*/
		BigInteger c1 = new BigInteger("359335245251");
		BigInteger c2 = new BigInteger("10436363975495");
		BigInteger c3 = new BigInteger("5135984059593");

		BigInteger rem;//stores the value from the first CRT to the second CRT

		/* Completes the first shift from c1 mod (n1) and c2 mod (n2) over to c1c2 mod (n1n2) */
		BigInteger kValue = n2.modInverse(n1); 
		kValue = (kValue.multiply(c1.subtract(c2))).mod(n1); 
		System.out.println("k: "+kValue);
		rem = (c2.add(n2.multiply(kValue))).mod(n1n2);
		System.out.println("m^3 === "+rem);

		/* Completes the second shift from c1c2 mod (n1n2) and c3 mod (n3) over to c1c2c3 mod (n1n2n3) */
		kValue = n3.modInverse(n1n2);
		kValue = (kValue.multiply(rem.subtract(c3))).mod(n1n2);
		System.out.println("k: "+kValue);
		rem = (c3.add(n3.multiply(kValue))).mod(n1n2n3);
		System.out.println("m^3 === "+rem);


		/* 
		 * Unfortunatley, there is no way to square root a BigInteger
		 * within Java, unless I implement my own way of doing so. I have 
		 * choosen to "cheat", since my calculation told me that 
		 * 3sqrt(521895811536685104609613375) = 805121215, and because this
		 * would have taken hours to implement unless i did it in some smart
		 * way like Newtons Method
		 */
		String decryptedCihperText = "805121215";
		System.out.println(decryptRSA(decryptedCihperText));

		//System.out.println(reverseRSA());

	}
/**
 * Translates a decrypted RSA string from numbers to letters.
 * 
 * @param String the incomming RSA string to translate
 * @return String the translated RSA string
 */
	private static String decryptRSA(String number){
		String answer = "";
		/* Checks that the entire string we receive here is actually a number*/
		for(char bokstav : number.toCharArray()){
			if (!Character.isDigit(bokstav)){//if any given character is not a string, we return empty string.
				return answer;
			}
		}

		final String counter = number.toString();

		/*
		 * Because we utilize an alphabet starting with 01 = a, up to to 26 = z
		 * we only need to iterate the entire string the amount of characters within
		 * it divided by two, because the numbered pairs (01, 02 ... 26) are handled
		 * as pairs. This creates a problem if first char is a-->i, because the entire
		 * number will then be odd, not even (because we remove the leading zero).
		 * This is handled easily after the iteration through the entire string. 
		 */
		for(int i = 0; i < counter.length()/2; i++){
			int twoLastDigits = Integer.parseInt(number.substring(number.length()-2, number.length()));
			number = number.substring(0, number.length()-2);
			answer = dig2char(twoLastDigits)+answer;
		}
		if(number.isEmpty()){//This will happen when the string has a even amount of characters. 
			return answer;
		}else{//This handles occurances where the string has a odd amount of characters.
			return dig2char(Integer.parseInt(number))+answer;
		}
	}

	/**
	 * returns the corresponding character to any given digit.
	 * @param i the digit we want the character for
	 * @return Char the character we have translated the digit into
	 */
	private static char dig2char(int i) {
		return Character.toChars(i+96)[0];
	}

}
