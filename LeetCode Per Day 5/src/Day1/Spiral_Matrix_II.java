package Day1;

public class Spiral_Matrix_II {
    // https://leetcode.com/problems/spiral-matrix-ii/submissions/
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;


        int minRow = 0;
        int maxRow = n - 1;
        int minCol = 0;
        int maxCol = n - 1;
        int i;
        int j;
        while (num <= n * n) {
            if (num > n * n) {
                break;
            }

            for (i = minRow, j = minCol; j <= maxCol; j++) {
                if (num > n * n) {
                    break;
                }
                matrix[i][j] = num++;
            }
            minRow++;
            for (i = minRow, j = maxCol; i <= maxRow; i++) {
                if (num > n * n) {
                    break;
                }
                matrix[i][j] = num++;
            }
            maxCol--;

            for (i = maxRow, j = maxCol; j >= minCol; j--) {
                if (num > n * n) {
                    break;
                }
                matrix[i][j] = num++;
            }
            maxRow--;

            for (i = maxRow, j = minCol; i >= minRow; i--) {
                if (num > n * n) {
                    break;
                }
                matrix[i][j] = num++;
            }
            minCol++;
        }
        return matrix;
    }
}
