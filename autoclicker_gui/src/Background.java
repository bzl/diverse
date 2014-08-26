import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * 
 * @author Kristoffer Tverå
 *
 */
class Background implements Runnable {
	
	private long jitter_random_low;
	private long jitter_random_high;
	private long random_low;
	private long random_high;
	private boolean alive;

	public Background (int jLow, int jHigh, int rLow, int rHigh){
		jitter_random_low = jLow;
		jitter_random_high = jHigh;
		
		random_low = rLow;
		random_high = rHigh;
		
	}

	public void stop(){
		this.alive=false;
		System.out.println("bababooey");
	}
	
	@Override
	public void run() {
		
		alive = true;
		
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

		long rate;
		long jitterRate;
		
		long random_diff = random_high-random_low;
		long jitter_diff = jitter_random_high-jitter_random_low;
		//autoclicker clicks 400 times, and waits aprox 2,5 seconds between each time
		while (alive) {
			rate = (long) (random_low+(Math.random()*random_diff));
			jitterRate = (long) (jitter_random_low+(Math.random()*jitter_diff));
			try {
				Robot robot = new Robot();
				try {
					Thread.sleep(rate);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					Thread.sleep(jitterRate);
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