public class Video_4_Search_a_2D_Matrix_II {
    // https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1/
    // https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
    // https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1/
    public boolean searchMatrix(int[][] matrix, int target) {
        int column = matrix[0].length - 1;
        int row = 0;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target)
                return true;
            else if (target < matrix[row][column])
                column -= 1;
            else
                row += 1;
        }
        return false;
    }
}
