
// https://www.geeksforgeeks.org/minimize-cost-of-painting-n-houses-such-that-adjacent-houses-have-different-colors/
//https://www.youtube.com/watch?v=jGywRalvoRw&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=24
public class Video_13_Paint_House_II {
    // T(C) : O(n^3)
    // S(C) : o(n^2)
    static long paint(int[][] arr, int n) {
        long[][] dp = new long[arr.length][arr[0].length];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = arr[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                long min = Integer.MAX_VALUE;
                for (int k = 0; k < dp[0].length; k++) {
                    if (k != j)
                        if (dp[i - 1][k] < min)
                            min = dp[i - 1][k];
                }
                dp[i][j] = arr[i][j] + min;
            }
        }
        long min = Integer.MAX_VALUE;
        for (int k = 0; k < dp[0].length; k++) {
            if (dp[arr.length - 1][k] < min)
                min = dp[arr.length - 1][k];
        }
        return min;
    }



    // T(C) : O(n^2)
    // S(C) : o(n^2)
    // Maintain two last and second minimum of previous rows to
    // prevent time complexity to go cubic order
    static long paint1(int[][] arr, int n) {

        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = arr[0][i];

            if (arr[0][i] <= least) {
                sleast = least;
                least = arr[0][i];
            } else if (arr[0][i] <= sleast) {
                sleast = arr[0][i];
            }
        }


        for (int i = 1; i < dp.length; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < dp[0].length; j++) {
                if (least == dp[i - 1][j]) {
                    dp[i][j] = arr[i][j] + sleast;
                } else {
                    dp[i][j] = arr[i][j] + least;
                }

                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }

            }

            least = nleast;
            nsleast = sleast;
        }
        return least;
    }

    public static void main(String[] args) {
        int N = 2;
        int cost[][] = {{1, 2, 3}, {1, 4, 6}};

        System.out.println(paint1(cost, N));
    }
}
