
public class random_number_generator {

	public static void main(String[] args) {
		long random_low = 2200;
		long random_high = 2800;
		
		long random_diff = random_high-random_low;
		
		//Generates a random number between low and high.
		long random = (long) (random_low+(Math.random()*random_diff));
		
		System.out.println(random);
		
		for (int i = 0; i <50; i++) {
			long random2 = (long) (random_low+(Math.random()*random_diff));
			System.out.println(random2);
		}

	}

}
