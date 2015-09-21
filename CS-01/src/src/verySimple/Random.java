package src.verySimple;
/**
 * Example code used for university course work.
 * 
 * @author Kristoffer Tverå (Bluekristoffer@gmail.com)
 */
public class Random {

	/*
	 * Displays the low average difference of running javas
	 *  random method an obscene amount of time, and also proves
	 *  why it is no good for crypto
	 */
	public static void main(String[] args) {

		java.util.Random tall = new java.util.Random();
		int difference = 0;
		for (int j = 0; j < 1000; j++) {

			int[] tab = new int[]{0,0};

			for (int i = 0; i < 1000000; i++) {
				int heltall = tall.nextInt(2);
				tab[heltall]++;
			}
			if(tab[0]>tab[1]){
				difference += (tab[0]-tab[1]);
			} else{
				difference += (tab[1]-tab[0]);
			}
			

		}

		difference = difference/1000;
		System.out.println(difference);

	}

}
