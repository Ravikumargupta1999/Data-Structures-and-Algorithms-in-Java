//https://www.geeksforgeeks.org/print-matrix-diagonal-pattern/
// https://practice.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=6&query=company[]Amazondifficulty[]0page6company[]Amazon

public class Print_Element_Diagonally {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int[] res = new int[n*n];
        boolean isUp = true;
        int i =0;
        int j=0;
        for(int k = 0;k<n*n;)
        {
            if (isUp) {
                for (; i >= 0 && j < n; j++, i--) {
                    res[k] = mat[i][j];
                    k++;
                }
                if (i < 0 && j <= n - 1)
                    i = 0;
                if (j == n) {
                    i = i + 2;
                    j--;
                }
            }
            else {
                for (; j >= 0 && i < n; i++, j--) {
                    res[k] = mat[i][j];
                    k++;
                }

                if (j < 0 && i <= n - 1)
                    j = 0;
                if (i == n) {
                    j = j + 2;
                    i--;
                }
            }

            isUp = !isUp;

        }
        return res;

    }
}
