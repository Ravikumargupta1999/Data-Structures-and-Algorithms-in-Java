// Done
import java.util.ArrayList;
import java.util.List;

public class Matrix44_Spiral_Traversal {
    // https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
    // https://leetcode.com/problems/spiral-matrix/submissions/868066063/
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> list = new ArrayList<>();
        int r = arr.length;
        int c = arr[0].length;
        int minRow = 0;
        int minCol = 0;
        int maxRow = arr.length - 1;
        int maxCol = arr[0].length - 1;
        int total = r * c;
        int count = 0;
        while (count < total) {
            for (int i = minRow, j = minCol; j <= maxCol && count < total; j++) {
                list.add(arr[i][j]);
                count++;
            }
            minRow++;
            for (int i = minRow, j = maxCol; i <= maxRow && count < total; i++) {
                list.add(arr[i][j]);
                count++;
            }
            maxCol--;
            for (int i = maxRow, j = maxCol; j >= minCol && count < total; j--) {
                list.add(arr[i][j]);
                count++;
            }
            maxRow--;
            for (int i = maxRow, j = minCol; i >= minRow && count < total; i--) {
                list.add(arr[i][j]);
                count++;
            }
            minCol++;
        }
        return list;
    }

    // https://leetcode.com/problems/spiral-matrix-ii/description/
    public int[][] generateMatrix(int n) {
        List<Integer> list = new ArrayList<>();
        int[][] matrix = new int[n][n];

        int minRow = 0;
        int minCol = 0;
        int maxRow = n - 1;
        int maxCol = n - 1;
        int total = n * n;
        int count = 1;
        while (count <= total) {
            for (int i = minRow, j = minCol; j <= maxCol && count <= total; j++) {
                matrix[i][j] = count;
                count++;
            }
            minRow++;
            for (int i = minRow, j = maxCol; i <= maxRow && count <= total; i++) {
                matrix[i][j] = count;
                count++;
            }
            maxCol--;
            for (int i = maxRow, j = maxCol; j >= minCol && count <= total; j--) {
                matrix[i][j] = count;
                count++;
            }
            maxRow--;
            for (int i = maxRow, j = minCol; i >= minRow && count <= total; i--) {
                matrix[i][j] = count;
                count++;
            }
            minCol++;
        }
        return matrix;
    }
}
