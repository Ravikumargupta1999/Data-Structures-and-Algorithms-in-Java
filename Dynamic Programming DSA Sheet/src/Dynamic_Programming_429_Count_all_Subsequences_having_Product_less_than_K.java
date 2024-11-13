public class Dynamic_Programming_429_Count_all_Subsequences_having_Product_less_than_K {
    // https://practice.geeksforgeeks.org/problems/number-of-subsets-with-product-less-than-k/1
    // https://www.youtube.com/watch?v=iOjV84903WA
    static int numOfSubsets(int[] arr, int n, int k) {

        int dp[][] = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {

                // number of subsequence using j-1 terms
                dp[i][j] = dp[i][j - 1];
//                System.out.println(i+"  "+j+"   "+dp[i][j]);
                if (arr[j - 1] <= i && arr[j - 1] > 0) {
//                    System.out.println("Hello "+(i/arr[j-1]));
                    dp[i][j] += dp[i / arr[j - 1]][j - 1] + 1;
                }
                // System.out.println();
            }
        }

        return dp[k][n];
    }


}
