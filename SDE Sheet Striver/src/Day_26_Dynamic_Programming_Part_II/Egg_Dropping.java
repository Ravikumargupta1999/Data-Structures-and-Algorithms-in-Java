package Day_26_Dynamic_Programming_Part_II;

public class Egg_Dropping {
    static int eggDrop(int e, int f) {

        int[][] dp = new int[e + 1][f + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {

                    int min = Integer.MAX_VALUE;


                    int prevRow = i - 1;
                    int currROw = i;

                    int prevCol = 0;
                    int currCol = j - 1;

                    while (prevCol < j) {
                        int val1 = dp[prevRow][prevCol];
                        int val2 = dp[currROw][currCol];

                        prevCol++;
                        currCol--;

                        int max = Math.max(val1, val2);

                        min = Math.min(min, max);
                    }

                    dp[i][j] = min + 1;

                }
            }
        }
        return dp[e][f];
    }
}
