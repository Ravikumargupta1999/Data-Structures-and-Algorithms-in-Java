//https://leetcode.com/problems/search-a-2d-matrix/
public class Video_3_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target);
        if (row == -1)
            return false;
        return binarySearch(matrix, row, target);
    }

    public int searchRow(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        int lc = matrix[0].length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][lc])
                return mid;
            else if (matrix[mid][0] < target) {
                lo = mid + 1;
            } else if (matrix[mid][0] > target) {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public boolean binarySearch(int[][] matrix, int row, int target) {
        int l = 0;
        int h = matrix[0].length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] < target)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return false;

    }
}
