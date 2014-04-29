package matrix;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 * Obscenely ineffective immitations of the matrix effect.
 * Currently implemented with one handler that "ticks" all the rows
 * in the effect. Can probably be optimized with  workload distributed over threads.
 * @author sysop
 *
 */
public class Matrix {
	public static void main(String[] args) {
		
		System.out.println("kake");

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int frameW = dim.width;
		int frameH = dim.height;

		//magicnumber is the spcing/row width for now.
		int magicNumber = 25;

		int numberOfRows = (frameW/magicNumber);

		boolean[] rowCheck = new boolean[numberOfRows];

		ArrayList<Row> rows = new ArrayList<Row>();

		
		do {
			//Pull a random number between 0 and rows-1
			int randomNumber = -1;
			do {
				randomNumber = (int) (Math.random()*numberOfRows);
				if(randomNumber == numberOfRows){
					randomNumber = -1;
				}
			} while (randomNumber < 0);
			
			//Checks if the row has been created. No created row = create new row.
			if(!rowCheck[randomNumber]){
				rows.add(new Row("help", frameH, randomNumber*magicNumber, magicNumber));
				rowCheck[randomNumber] = true;
			}
			//increments all rows.
			for (Row row : rows) {
				row.tick();
			}
			
			//waiting time between iterations
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} while (true);
	}
}
