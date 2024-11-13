package InterviewQuestion;

public class Video_92_Anti_Diagonal_Traversal_Of_Matrix {
    // https://practice.geeksforgeeks.org/problems/print-diagonally1623/1
    public static void main(String[] args) {
        System.out.println(args[0] + "  " + args[1]);
    }
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        int i = 0;
        int j = 0;
        int[] res = new int[matrix[0].length * matrix.length];
        int k = 0;
        while (j < matrix[0].length) {
            int row = i;
            int col = j;

            while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
                res[k++] = matrix[row][col];
                row++;
                col--;
            }
            j++;
        }

        j = matrix[0].length - 1;
        i = 1;
        while (i < matrix.length) {
            int row = i;
            int col = j;

            while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
                res[k++] = matrix[row][col];
                row++;
                col--;
            }
            i++;
        }
        return res;
    }
}
