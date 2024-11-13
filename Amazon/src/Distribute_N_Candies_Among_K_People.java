import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/distribute-n-candies/1
//https://leetcode.com/problems/distribute-candies-to-people/submissions/
public class Distribute_N_Candies_Among_K_People {
    static Long[] distributeCandies(int n, int k) {
        long[] res = new long[k];
        for (int i = 0; n > 0; i++) {
            res[i % k] += Math.min(n, i + 1);
            n -= (i + 1);
        }
        Long[] arr = new Long[k];
        for(int i=0;i<k;i++)
        {
            arr[i] = res[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        Long a = (long) 12;
        Long b = (long) 12;
        Long c = (long) ((long) a + (long) b);
        System.out.println(c);
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }
}
