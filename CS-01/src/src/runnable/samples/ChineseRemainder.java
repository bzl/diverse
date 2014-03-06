package src.runnable.samples;

public class ChineseRemainder {

    public static void main(String[] args)
	{
	        ChineseRemainder cr = new ChineseRemainder();
	        long a[] = new long[]{7,3};
	        long m[] = new long[]{12345,11111};
	       
	        long x = cr.findSolution(a, m);
	       
	        System.out.println("Solution:"+x);
	}

	//find x given x = a1 (mod m1), x = a2 (mod m2) ...
    public long findSolution(long[] a, long[] m)
    {
            if(a==null || m ==null)
               {
                 System.out.println("a or m must have at least 2 elements");
                 return -1;
               }
            if(a.length<2 || m.length<2)
            {
                    System.out.println("Length of a or m are less than 2");
                    return -1;
            }
            if(a.length != m.length)
            {
                    System.out.println("Length of a and m are not same");
                    return -1;
            }
           
            long x = a[0];
            long mInverse, y;
            long mi = 1;
            int i = 0;
           
           
            while(i< a.length-1)
            {
           
                    mi*=m[i];
                   
                    //check if the m's are relatively prime
                    if(gcd(m[i+1],mi)!=1)
                    {
                            System.out.println("The m's are not relatively prime->"+m[i+1]+","+mi);
                            return -1;
                    }
                           
                    //find mi_inverse (mod m[i+1])
                    mInverse = inverse(m[i+1], mi);
                    if(mInverse<0)
                            mInverse+= m[i+1];
           
                    y = ((a[i+1] - x)*mInverse)% m[i+1];
                    if(y<0)
                            y+= m[i+1];
                   
                    //System.out.print("Step:"+i+"->x="+x+"+"+mi+"*"+y+"=");
                   
                    x = x + mi*y;
                   
                   
                    //System.out.println(x);
                   
                    i++;
            }
           
            return x;
    }
   
    public static long gcd(long a, long b)
    {
            if(b==0)
                    return a;
            else
                    return gcd(b, a % b);
    }
    
    public static long inverse (long p, long g)
    {
            //g inverse = g ^ (p-2) (mod p)

            long[] gInverse = ExtendedEuclid(p, g);//crypto.fastSq(p, g, p-2);
            //System.out.println(gInverse[1]+" "+gInverse[2]);
            if(gInverse[2]<0)
                    return p+gInverse[2];
            return gInverse[2];
           
    }


    public static long[] ExtendedEuclid(long a, long b)
       /*  This function will perform the Extended Euclidean algorithm
           to find the GCD of a and b.  We assume here that a and b
           are non-negative (and not both zero).  This function also
           will return numbers j and k such that
                  d = j*a + k*b
           where d is the GCD of a and b.
       */
       {
           long[] ans = new long[3];
           long q;

           if (b == 0)  {  /*  If b = 0, then we're done...  */
               ans[0] = a;
               ans[1] = 1;
               ans[2] = 0;
           }
           else
               {     /*  Otherwise, make a recursive function call  */
                  q = a/b;
                  ans = ExtendedEuclid (b, a % b);
                  long temp = ans[1] - ans[2]*q;
                  ans[1] = ans[2];
                  ans[2] = temp;
               }

           return ans;
       }

}
