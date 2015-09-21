package src.runnable.samples;
/**
 * Example code used for university course work.
 * 
 * @author Kristoffer Tverå (Bluekristoffer@gmail.com)
 */
public class pg1100h2012sem2 {

	/**
	 * PG1100, H�sten 2012, Innlevering 2
	 * 
	 * @author Kristoffer Tver�
	 */
	public static void main(String[] args) {
		System.out.println("Firkant:");
		firkant('O', 5);
		System.out.println("Pyramide:");
		pyramide('x', 5, false);
		System.out.println("Diamant:");
		diamant('*', 10);
		System.out.println("Timeglass:");
		timeglass('o', 10);
		System.out.println("Krystall:");
		krystall('+', 15);
	}
	/**
	 * Tegner en krystall
	 * 
	 * @param tegn tegnet som brukes for � tegne krystallen
	 * @param size st�rrelsen p� krystallen
	 */
	private static void krystall(char tegn, int size) {
		pyramide(tegn, size/3, false);
		firkant(tegn, size/3);
		pyramide(tegn, size/3, true);
	}

	/**
	 * Tegner et timeglass
	 * 
	 * @param tegn tegnet som brukes for � tegne timeglasses
	 * @param size st�rrelsen p� timeglasset
	 */
	private static void timeglass(char tegn, int size) {
		pyramide(tegn, size/2, true);
		pyramide(tegn, size/2, false);
	}

	/**
	 * Tegner en diamant
	 * 
	 * @param tegn tegnet som brukes for � tegne diamanten
	 * @param size st�rrelsen p� diamanten
	 */
	private static void diamant(char tegn, int size) {
		pyramide(tegn, size/2, false);
		pyramide(tegn, size/2, true);
	}

	/**
	 * Tegner en pyramide
	 * 
	 * @param tegn tegnet som brukes for � tegne pyramiden
	 * @param size st�rrelsen p� pyramiden
	 * @param peker retningen til pyramiden. false = peker opp, true = peker ned
	 */
	private static void pyramide(char tegn, int size, boolean peker) {
		if(peker){
			for(int i = 0; i < size; i++){
				for(int j = 0; j < i; j++){
					System.out.print(" ");
				}
				for(int j = i; j < size; j++){
					System.out.print(tegn+" ");
				}
				System.out.println();
			}
		}
		else{
			for(int i = 0; i < size; i++){
				for(int j = (size-1); j > i; j--){
					System.out.print(" ");
				}
				for(int j = 0; j <= i; j++){
					System.out.print(tegn+" ");
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * Tegner en firkant
	 * 
	 * @param tegn tegnet som brukes for � tegne firkanten
	 * @param size st�rrelsen p� firkanten
	 */
	private static void firkant(char tegn, int size) {
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print(tegn+" ");
			}
			System.out.println();
		}
	}
}
