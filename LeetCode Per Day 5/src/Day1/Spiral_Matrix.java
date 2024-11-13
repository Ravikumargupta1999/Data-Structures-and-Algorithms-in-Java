package Day1;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    // https://leetcode.com/problems/spiral-matrix/submissions/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int total = 0;


        int minRow = 0;
        int maxRow = m - 1;
        int minCol = 0;
        int maxCol = n - 1;
        int i;
        int j;
        while (total < m*n) {
            if(total == m*n){
                break;
            }
            for (i = minRow, j = minCol; j <= maxCol; j++) {
                if(total == m*n){
                    break;
                }
                list.add(matrix[i][j]);
                total++;
            }
            minRow++;
            for (i = minRow, j = maxCol; i <= maxRow; i++) {
                if(total == m*n){
                    break;
                }
                list.add(matrix[i][j]);
                total++;
            }
            maxCol--;

            for (i = maxRow, j = maxCol; j >= minCol; j--) {
                if(total == m*n){
                    break;
                }
                list.add(matrix[i][j]);
                total++;
            }
            maxRow--;

            for (i = maxRow, j = minCol; i >= minRow; i--) {
                if(total == m*n){
                    break;
                }
                list.add(matrix[i][j]);
                total++;
            }
            minCol++;
        }
        return list;
    }
}
