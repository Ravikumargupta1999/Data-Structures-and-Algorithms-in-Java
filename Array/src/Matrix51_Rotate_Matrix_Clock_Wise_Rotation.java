//Done
public class Matrix51_Rotate_Matrix_Clock_Wise_Rotation {

    // https://leetcode.com/problems/rotate-image/

    public static void RotateBy90Degree(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
    static void rotateby90(int matrix[][], int n)
    {
        // int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int left = 0;
            int right = matrix.length - 1;
            while (left < right) {
                int temp = matrix[left][i];
                matrix[left][i] = matrix[right][i];
                matrix[right][i] = temp;
                left++;
                right--;
            }
        }
    }
}
