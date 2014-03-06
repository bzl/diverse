package src.runnable.samples;

public class recursive {

	/**
	 * Very siple examples of recursive calls.
	 * @author ktv095
	 */
	public static void main(String[] args) {
		/*
		 * Integers 1-n are suitable as input
		 */
		int input = 8;
		
		System.out.println(fac(input));
		System.out.println(fib(input));
		System.out.println(sum(input));
	}

	/**
	 * Calculates n + (n-1) + (n-2) .. + 1
	 * given n > 1
	 * 
	 * @param input input integer
	 * @return sum
	 */
	private static int sum(int input) {
		if(input == 1)
			return 1;
		return input + sum(input-1);
		
	}

	/**
	 * Calculates the n-th fib-number in a 0 oriented fib 
	 * sequence (0-1-1-2-3-5-8-13..)
	 * 
	 * @param input
	 * @return sum of n-th fib-number
	 */
	private static int fib(int input) {
		if(input == 0)
			return 0;
		if(input == 1)
			return 1;
		return fib(input-1)+fib(input-2);
	}

	/**
	 * Calculates n * (n-1) * (n-2) .. * 1
	 * given n > 1
	 * 
	 * @param input input integer
	 * @return sum
	 */
	private static int fac(int input) {
		if(input == 1)
			return 1;
		return input * fac(input-1);
	}

}
