package src.verySimple;

public class Random {

	/**
	 * @param args
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
