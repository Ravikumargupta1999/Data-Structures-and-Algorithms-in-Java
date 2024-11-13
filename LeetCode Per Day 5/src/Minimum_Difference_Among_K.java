import java.util.Arrays;

public class Minimum_Difference_Among_K {

    long minDiff(long a[] ,int N,int K)
    {
        Arrays.sort(a);
        long min = Long.MAX_VALUE;
        for (int i=0;i<N-K+1;i++)
            min = Math.min(min,a[i+(K-1)]-a[i]);
        return min;

    }
}
