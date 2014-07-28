package inf247;
public class Test {

	public static void main(String[] args) {
			byte b1 = (byte) 17;
			String s1 = String.format("%5s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
			System.out.println(s1); // 10001

			byte b2 = (byte) 28;
			String s2 = String.format("%5s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
			System.out.println(s2); // 11100

			byte b3 = (byte) ((byte) b1^b2);
			String s3 = String.format("%5s", Integer.toBinaryString(b3 & 0xFF)).replace(' ', '0');
			System.out.println(s3); // 01101
			
			
				
			float n = 4.0f;
			
			float k = 3.0f;
			
			float p = 1/6;
			
			float q = 1-p;
			
			float prod1;
			
			float prod2;
			
			float prod3;
			
			prod1 = n/k;
			System.out.println(prod1);
			
			prod2 = (float) Math.pow(p, k);
			System.out.println(prod2);
			
			prod3 = (float) Math.pow(q, (n-k));
			System.out.println(prod3);
			
			System.out.println(prod1*prod2*prod3);
			
			
			
	}
}