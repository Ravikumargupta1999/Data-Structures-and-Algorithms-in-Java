public class Video_1_Fibonacci_Memoized {

    public static int fibMemoized(int n,int[] qb)
    {
        if (n == 0 || n == 1)
            return n;
        if(qb[n] != 0)
            return qb[n];
        int fibn1 = fibMemoized(n-1,qb);
        int fibn2 = fibMemoized(n-2,qb);
        int fibn = fibn1+ fibn2;
        qb[n] = fibn;
        return fibn;
    }
}
