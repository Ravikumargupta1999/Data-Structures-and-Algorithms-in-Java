import java.util.Map;
// https://practice.geeksforgeeks.org/problems/faithful-numbers0014/1
public class Faithful_Numbers {
    static Long nthFaithfulNum(int n) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        int l =1;
        long val = 0;
        int count = 0;
        System.out.println(1 +" --> "+dp[1]);
        for(int i =2; i<= n;i++)
        {
            if(i == (int) Math.pow(2,l))
            {
                dp[i] = (long) Math.pow(7,l);
                val = dp[i];
                l++;
                count = 1;
            }
            else
            {
                dp[i] = val + dp[count++];
            }
            System.out.println(i +" --> "+dp[i]);
        }
        for(int i=1;i<=n;i++)
            System.out.print(dp[i]+"  ");
        System.out.println("");
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthFaithfulNum(12));
    }
}
