public class Rotate_by_90_degree {
    //Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][], int n) {
        //int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // for anticlock wise
        // gfg
        //https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
        //https://www.youtube.com/watch?v=SoxrXQbhCPI&list=PL-Jc9J83PIiFkOETg2Ybq-FMuJjkZSGeH&index=11
        for (int i = 0; i < matrix.length; i++) {
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

        // for clock wise
        // leetcode
        //https://leetcode.com/problems/rotate-image/submissions/
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
