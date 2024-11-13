//https://practice.geeksforgeeks.org/problems/adjacents-are-not-allowed3528/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=0&page=1&query=category[]Dynamic%20Programmingdifficulty[]0page1category[]Dynamic%20Programming#

public class Video_19_Adjacents_Are_Not_Allowed {
    static int maxSum(int n, int mat[][]) {
        if (n == 1)
            return Math.max(mat[0][0], mat[1][0]);
        else if (n == 2)
            return Math.max(Math.max(mat[0][0], mat[1][0]), Math.max(mat[0][1], mat[1][1]));


        int incl = Math.max(mat[0][0], mat[1][0]);
        int excl = 0, excl_new;
        for (int i = 1; i < n; i++) {
            excl_new = Math.max(excl, incl);
            incl = excl + Math.max(mat[0][i], mat[1][i]);
            excl = excl_new;
        }
        return Math.max(excl, incl);
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] mat = {{1, 4, 5},
                {2, 0, 0}};
        System.out.println(maxSum(N, mat));
    }
}
