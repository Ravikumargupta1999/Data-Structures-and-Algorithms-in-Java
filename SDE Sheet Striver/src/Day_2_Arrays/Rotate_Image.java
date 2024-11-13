package Day_2_Arrays;

public class Rotate_Image {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Rotate_Image obj = new Rotate_Image();
        obj.print(matrix);
        obj.rotate(matrix);
        obj.print(matrix);
    }

    public void print(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int val : arr) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    public void rotate(int[][] matrix) {
        transformation(matrix);
        swap(matrix);
    }

    public void transformation(int[][] matrix) {
        int row = 0;
        int col = 0;

        while (row < matrix.length) {
            int newRow = row;
            int newCol = col;

            while (newRow < matrix.length && newCol < matrix.length) {
                int temp = matrix[row][newCol];
                matrix[row][newCol] = matrix[newRow][col];
                matrix[newRow][col] = temp;
                newCol++;
                newRow++;
            }
            row++;
            col++;
        }
    }

    public void swap(int[][] matrix) {
        int start = 0;
        int end = matrix[0].length - 1;

        while (start < end) {
            swapColum(matrix, start, end);
            start++;
            end--;
        }
    }

    public void swapColum(int[][] matrix, int st, int end) {
        int row = 0;
        while (row < matrix.length){
            int temp = matrix[row][st];
            matrix[row][st] = matrix[row][end] ;
            matrix[row][end] = temp;
            row++;
        }
    }


    public void rotate1(int[][] matrix) {
        int n = matrix.length;
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
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

}
