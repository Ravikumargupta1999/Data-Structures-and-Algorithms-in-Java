

// Done
// https://leetcode.com/problems/search-a-2d-matrix/

public class Matrix45_Search_In_2D_Matrix {
    // https://leetcode.com/problems/search-a-2d-matrix/description/
    public boolean searchMatrixLeetCode(int[][] matrix, int target) {
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

// https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1?category%5B%5D=Matrix&category%5B%5D=Matrix&page=1&query=category%5B%5DMatrixpage1category%5B%5DMatrix


    public static int matSearch(int matrix[][], int N, int M, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i <= matrix.length - 1 && j >= 0) {
            if (matrix[i][j] == target) {
                return 1;
            } else if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {

                j--;
            }
        }
        return 0;
    }

    // https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1?category%5B%5D=Matrix&category%5B%5D=Matrix&page=1&query=category%5B%5DMatrixpage1category%5B%5DMatrix
    static boolean search(int matrix[][], int n, int m, int target) {
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

    //    https://leetcode.com/problems/sort-colors/description/
    public void sortColors(int[] nums) {
        int c0 =0;
        int c1 = 0;
        int c2 = 0;
        for (int num : nums){
            if(num == 0)
                c0++;
            else if(num == 1)
                c1++;
            else
                c2++;
        }
        int i = 0;
        while (c0-- > 0)
            nums[i++] = 0;
        while (c1-- > 0)
            nums[i++] = 1;
        while (c2-- > 0)
            nums[i++] = 2;
    }

}
