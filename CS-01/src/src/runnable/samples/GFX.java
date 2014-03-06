package src.runnable.samples;

public class GFX {

	/**
	 * PG1100, Høsten 2012, Innlevering 2
	 * 
	 * @author Kristoffer Tverå
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
	 * @param tegn tegnet som brukes for å tegne krystallen
	 * @param size størrelsen på krystallen
	 */
	private static void krystall(char tegn, int size) {
		pyramide(tegn, size/3, false);
		firkant(tegn, size/3);
		pyramide(tegn, size/3, true);
	}

	/**
	 * Tegner et timeglass
	 * 
	 * @param tegn tegnet som brukes for å tegne timeglasses
	 * @param size størrelsen på timeglasset
	 */
	private static void timeglass(char tegn, int size) {
		pyramide(tegn, size/2, true);
		pyramide(tegn, size/2, false);
	}

	/**
	 * Tegner en diamant
	 * 
	 * @param tegn tegnet som brukes for å tegne diamanten
	 * @param size størrelsen på diamanten
	 */
	private static void diamant(char tegn, int size) {
		pyramide(tegn, size/2, false);
		pyramide(tegn, size/2, true);
	}

	/**
	 * Tegner en pyramide
	 * 
	 * @param tegn tegnet som brukes for å tegne pyramiden
	 * @param size størrelsen på pyramiden
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
	 * @param tegn tegnet som brukes for å tegne firkanten
	 * @param size størrelsen på firkanten
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
