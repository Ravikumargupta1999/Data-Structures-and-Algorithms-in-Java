// https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1
// https://www.youtube.com/watch?v=UvksR0hR9nA&t=37s
public class D_Dynamic_Programming_432_Egg_Dropping_Problem {
    public static int eggDrop(int e, int f) {
        int[][] dp = new int[e + 1][f + 1];

        for (int eggs = 1; eggs < dp.length; eggs++) {

            for (int floors = 1; floors < dp[0].length; floors++) {

                if (eggs == 1) {
                    dp[eggs][floors] = floors;

                } else if (floors == 1) {
                    dp[eggs][floors] = 1;

                } else {

                    int min = Integer.MAX_VALUE;


                    int row1 = eggs - 1;
                    int row2 = eggs;

                    int col1 = 0;
                    int col2 = floors - 1;

                    while (col1 < floors) {
                        int val1 = dp[row1][col1];
                        int val2 = dp[row2][col2];

                        col1++;
                        col2--;

                        int max = Math.max(val1, val2);

                        min = Math.min(min, max);
                    }

                    dp[eggs][floors] = min + 1;

                }
            }
        }
        return dp[e][f];
    }
}
