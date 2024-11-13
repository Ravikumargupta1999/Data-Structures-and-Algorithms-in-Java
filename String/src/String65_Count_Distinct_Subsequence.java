import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1#

public class String65_Count_Distinct_Subsequence {
    static int distinctSubsequences(String str) {
        double p = 1000000007;
        double[] dp = new double[str.length() + 1];
        dp[0] = 1;
        double value = 0;
        HashMap<Character, Double> map = new HashMap<>();
        for (double i = 1; i < dp.length; i++) {
            value = 2 * (dp[(int)i - 1]);
            System.out.print(value+"  ");
            dp[(int)i] = value % p;
            char ch = str.charAt((int)i - 1);
            if (map.containsKey(ch)) {
                double j = map.get(ch);
                value = (dp[(int)i] % p - dp[(int)j - 1] % p) % p;
                System.out.print(value+"   "+dp[(int)i]+"    "+dp[(int)j-1]+"   ");
                dp[(int)i] = value % p;
                System.out.println(dp[(int)i]+"   "+ch);
            }
            map.put(ch, i);
        }
        System.out.println(dp[str.length()]);
        return (int) (dp[str.length()] % p);

    }

    public static void main(String[] args) {
        System.out.println(distinctSubsequences("ughfmljhheqkclutyueaswgunxiykfjelsmyfv"));
        // output : 796839209
    }
}
