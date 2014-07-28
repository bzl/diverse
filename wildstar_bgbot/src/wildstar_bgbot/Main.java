package wildstar_bgbot;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Main {
	static Robot robot;
	static boolean alive;

	public static void main(String[] args) {
		alive = true;
		startGuide();
		
		
		doNothing(5);
		type("bababooey");

				
		//
		//		while(alive){
		//			reloadUI();
		//			openScrollBar();
		//			selectPractise();
		//			clickRandom();
		//			clickJoin();
		//
		//			for(int i = 0; i < 5; i++){
		//				doNothing(30);
		//				clickEnterBG();
		//			}
		//
		//			for(int i = 0; i < 20; i++){
		//				doNothing(30);
		//				follow();
		//			}
		//		}
	}

	private static void follow() {
		type("/follow");
	}

	private static void type(String characters) {

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection( characters );
		clipboard.setContents(stringSelection, stringSelection);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		jitterpause();
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}




	private static void jitterpause() {
		long interval = (long) (20+Math.random()*40);

		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void doNothing(int i) {
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void clickEnterBG() {
		clickMouse(0,0);
		doNothing(2);
	}

	private static void clickMouse(int i, int j) {
		// TODO Auto-generated method stub

	}

	private static void clickJoin() {
		clickMouse(0,0);
		doNothing(2);
	}

	private static void clickRandom() {
		clickMouse(0,0);
		doNothing(2);
	}

	private static void selectPractise() {
		clickMouse(0,0);
		doNothing(2);
	}

	private static void openScrollBar() {
		clickMouse(0,0);
		doNothing(2);
	}

	private static void reloadUI() {
		type("/reloadui");
	}

	/*
	 * deprecated
	 */
	private static boolean running() {
		int[] position = getMousePos();
		if (position[0] > 200 && position[0] < 250 &&
				position[1] > 200 && position[1] < 250)
			return true;
		return false;
	}

	private static int[] getMousePos() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int[] position = new int[]{(int) b.getX(), (int) b.getY()};
		return position;
	}

	private static void startGuide() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			System.exit(0);
		}

		toast("Hello. I am HAL9000", 5);


	}

	private static void toast(String string, int i) {
		// TODO Auto-generated method stub

	}

}
