
//https://leetcode.com/problems/knight-probability-in-chessboard/submissions/
// https://practice.geeksforgeeks.org/problems/probability-of-knight5529/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=4&query=category[]Dynamic%20Programmingdifficulty[]1page4category[]Dynamic%20Programming

public class Video_37_Probability_of_Knight {
    public static boolean isValid(int ni, int nj, int n) {
        if (ni >= 0 && nj >= 0 && ni < n && nj < n)
            return true;
        return false;
    }

    public static double findProb(int n, int x, int y, int k) {
        double[][] curr = new double[n][n];
        double[][] next = new double[n][n];
        curr[x][y] = 1;
        for (int m = 1; m <= k; m++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int ni = 0;
                    int nj = 0;

                    ni = i - 2;
                    nj = j - 1;
                    if (isValid(ni, nj, n))
                        next[ni][nj] += curr[i][j] / 8.0;

                    ni = i - 2;
                    nj = j + 1;
                    if (isValid(ni, nj, n))
                        next[ni][nj] += curr[i][j] / 8.0;


                    ni = i - 1;
                    nj = j - 2;
                    if (isValid(ni, nj, n))
                        next[ni][nj] += curr[i][j] / 8.0;


                    ni = i - 1;
                    nj = j + 2;
                    if (isValid(ni, nj, n))
                        next[ni][nj] += curr[i][j] / 8.0;


                    ni = i + 1;
                    nj = j - 2;
                    if (isValid(ni, nj, n))
                        next[ni][nj] += curr[i][j] / 8.0;


                    ni = i + 1;
                    nj = j + 2;
                    if (isValid(ni, nj, n))
                        next[ni][nj] += curr[i][j] / 8.0;


                    ni = i + 2;
                    nj = j - 1;
                    if (isValid(ni, nj, n))
                        next[ni][nj] += curr[i][j] / 8.0;

                    ni = i + 2;
                    nj = j + 1;
                    if (isValid(ni, nj, n))
                        next[ni][nj] += curr[i][j] / 8.0;
                }
            }
            curr = next;
            next = new double[n][n];

        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += curr[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(findProb(8, 0, 0, 3));
    }
}
