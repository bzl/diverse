import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Kristoffer Tverå
 *
 */
class background implements Runnable {
	int secondsBetweenJump;
	boolean alive = true;

	public background (int seconds){
		secondsBetweenJump = seconds;
	}

	@Override
	public void run() {
		long sleepTime = (secondsBetweenJump*1000) + (long) (Math.random()*3000);
		try {
			Thread.currentThread();
			//wait before first execution to allow user to enter app
			Thread.sleep(sleepTime);
			Robot robot = new Robot();

			System.out.println("Thread is about to do work");
			while(alive){

				Thread.sleep(sleepTime);
				System.out.println("ping");
								int keyPress = (int) (Math.random()*6);
								long jitter = 50 + (long) (Math.random()*50);
								
								switch (keyPress) {
				
								case 1:
									robot.keyPress(KeyEvent.VK_W);
									Thread.sleep(jitter);
									robot.keyRelease(KeyEvent.VK_W);
									break;
								case 2:
									robot.keyPress(KeyEvent.VK_A);
									Thread.sleep(jitter);
									robot.keyRelease(KeyEvent.VK_A);
									break;
								case 3:
									robot.keyPress(KeyEvent.VK_S);
									Thread.sleep(jitter);
									robot.keyRelease(KeyEvent.VK_S);
									break;
								case 4:
									robot.keyPress(KeyEvent.VK_D);
									Thread.sleep(jitter);
									robot.keyRelease(KeyEvent.VK_D);
									break;
				
								default:
									robot.keyPress(KeyEvent.VK_SPACE);
									Thread.sleep(jitter);
									robot.keyRelease(KeyEvent.VK_SPACE);
									break;
								}
			}
			if (Thread.interrupted()) {
				throw new InterruptedException();
			}

		} catch (InterruptedException e1) {
			System.out.println("thread killed");
			alive=false;
			return;
		} catch (AWTException e2) {
			System.out.println("awt lolwut");
			e2.printStackTrace();
		}
	}
	
	public void kill(){
		alive=false;
	}
	
}