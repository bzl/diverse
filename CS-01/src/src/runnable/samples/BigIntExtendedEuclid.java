package src.runnable.samples;

import java.math.BigInteger;


public class BigIntExtendedEuclid {

   //  return array [d, a, b] such that d = gcd(p, q), ap + bq = d
   static BigInteger[] gcd(BigInteger p, BigInteger q) {
      if (q.equals(BigInteger.ZERO))
         return new BigInteger[] { p, BigInteger.ONE, BigInteger.ZERO };

      BigInteger[] vals = gcd(q, p.mod(q));
      BigInteger d = vals[0];
      BigInteger a = vals[2];
      BigInteger b = vals[1].subtract((p.divide(q)).multiply(vals[2]));
      return new BigInteger[] { d, a, b };
   }

   public static void main(String[] args) {
//	   BigInteger p = new BigInteger("359335245251");
//	   BigInteger q = new BigInteger("10436363975495");
	   BigInteger p = new BigInteger("2469247531693");
	   BigInteger q = new BigInteger("11111502225583");
//	   BigInteger p = new BigInteger("11111");
//	   BigInteger q = new BigInteger("12345");
	   BigInteger vals[] = gcd(p, q);
      System.out.println("gcd(" + p + ", " + q + ") = " + vals[0]);
      System.out.println(vals[1] + "(" + p + ") + " + vals[2] + "(" + q + ") = " + vals[0]);
   }
}