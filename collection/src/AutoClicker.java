import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.io.IOException;

/**
 * 
 * @author Kristoffer Tver�
 *
 */
public class AutoClicker {
	private static long jitter_random_low = 2500;
	private static long jitter_random_high = 3000;
	private static long random_low = 2500;
	private static long random_high = 3000;
	private static long rate;

	public static void main(String[] args) throws IOException {
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		

		long random_diff = random_high-random_low;
		//autoclicker clicks 400 times, and waits aprox 2,5 seconds between each time
		for (int i = 0; i < 500; i++) {
			System.out.println(i);
			rate = (long) (random_low+(Math.random()*random_diff));
			try {
				Robot robot = new Robot();
				try {
					Thread.sleep(rate);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					long jitter_rate = jitter_random_low + (long) (Math.random()*jitter_random_high-jitter_random_low);
					Thread.sleep(jitter_rate);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
				} catch (InterruptedException ex) {
					//Exception handeling is for the weak
				}
			} catch (AWTException e) {
				//I like to live risky
			}
		}
		//Audio alert post execution
		Toolkit.getDefaultToolkit().beep();
	}
}