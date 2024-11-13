public class D_Dynamic_Programming_411_Rod_Cuttings {
    // https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
    // https://www.youtube.com/watch?v=SZqAQLjDsag
    public static int cutRod(int[] price, int n) {
        int[] piece = new int[n];
        for (int i = 0; i < n; i++)
            piece[i] = i + 1;


        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (i >= piece[j]) {
                    int profit = price[j] + dp[i - piece[j]];
                    max = Math.max(max, profit);
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price, price.length));
    }
}
