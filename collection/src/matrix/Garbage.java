package matrix;

public class Garbage {
	public static void main(String[] args) {
		System.out.println("before");
		Row testRow = new Row("10", 768, 600, 25);

		//		for (int i = 0; i < 55; i++) {
		//			try {
		//				Thread.sleep(50);
		//			} catch (InterruptedException e) {
		//				e.printStackTrace();
		//			}
		//			testRow.tick();
		//		}

		//testRow.run();
		
		
		System.out.println("after");
	}
}
