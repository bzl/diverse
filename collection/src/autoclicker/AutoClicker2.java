package autoclicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.io.IOException;

/**
 * Example code used for university course work.
 * 
 * @author Kristoffer Tverå (Bluekristoffer@gmail.com)
 */
public class AutoClicker2 {
	public static void main(String[] args) throws IOException {
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		/*
		 * In order to obtain a random number between 2400 and 2800
		 * I add the lower (2400) and 0-->100% of the difference 
		 * between the two numbers. Simple shit.
		 */
		long random_low = 2800;
		long random_high = 3400;
		long rate;
		long random_diff = random_high-random_low;
		//autoclicker clicks 400 times, and waits aprox 2,5 seconds between each time
		while (true) {
			rate = (long) (random_low+(Math.random()*random_diff));
			try {
				Robot robot = new Robot();
				try {
					Thread.sleep(rate);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				} catch (InterruptedException ex) {
					//Exception handeling is for the weak
				}
			} catch (AWTException e) {
				//I like to live risky
			}
		}
	}
}