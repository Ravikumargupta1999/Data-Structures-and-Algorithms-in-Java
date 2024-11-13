import java.util.Arrays;
import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1#
// https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
public class D_Dynamic_Programming_425_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n;i++)
            arr[i] = s.nextInt();
        int value = LongestIncreasingSubsequences(n,arr);
        System.out.println(value);
    }
    // gfg article

    static int longestSubsequence(int n, int v[])
    {
        if (v.length == 0)
            return 0;

        int[] tail = new int[v.length];
        int length = 1;
        tail[0] = v[0];

        for (int i = 1; i < v.length; i++) {

            if (v[i] > tail[length - 1]) {

                tail[length++] = v[i];
            }
            else {

                int idx = Arrays.binarySearch(
                        tail, 0, length - 1, v[i]);

                if (idx < 0)
                    idx = -1 * idx - 1;

                tail[idx] = v[i];
            }
        }
        return length;
    }
    // Sumit Malik
    public static int LongestIncreasingSubsequences(int n,int[] a)
    {
        int[] dp = new int[n];
        int omax = 0;
        for(int i=0;i<dp.length;i++)
        {
            int max =0;
            for(int j=0;j<i;j++)
            {
                if(a[j]<a[i])
                {
                    if(dp[j]>max)
                        max=dp[j];
                }
            }

            dp[i] = max +1;
            if(dp[i]>omax)
                omax = dp[i];
        }
        return  omax;
    }
}
