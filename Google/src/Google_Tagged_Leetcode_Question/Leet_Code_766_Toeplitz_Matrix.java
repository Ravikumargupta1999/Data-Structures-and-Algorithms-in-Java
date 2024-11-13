package Google_Tagged_Leetcode_Question;

public class Leet_Code_766_Toeplitz_Matrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int startRow = matrix.length - 1;

        // lower Diagonal Check

        while (startRow >= 0) {
            int currRow = startRow;
            int currCol = 0;
            int num = matrix[currRow][currCol];
            while (currRow < matrix.length && currCol < matrix[0].length) {
                if (matrix[currRow][currCol] != num)
                    return false;
                currCol++;
                currRow++;
            }
            startRow--;
        }

        // Upper diagonal check
        int startCol = 0;
        while (startCol < matrix[0].length) {
            int currRow = 0;
            int currCol = startCol;
            int num = matrix[currRow][currCol];
            while (currRow < matrix.length && currCol < matrix[0].length) {
                if (matrix[currRow][currCol] != num)
                    return false;
                currCol++;
                currRow++;
            }
            startCol++;
        }
        return true;
    }
}
