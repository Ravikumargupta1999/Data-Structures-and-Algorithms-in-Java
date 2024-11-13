package Day_11_Binary_Search;

public class Median_Of_A_Matrix {
    int median(int[][] matrix, int r, int c) {
        int low = 1;
        int high = 2000;

        while (low <= high) {
            int mid = (low + high) >> 1;

            int count = 0;
            for (int i = 0; i < r; i++)
                count += lesserThanMid(matrix[i], mid);
            if (count <= (r * c) / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    int lesserThanMid(int[] arr, int mid) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int md = (low + high) >> 1;

            if (arr[md] <= mid) {
                low = md + 1;
            } else {
                high = md - 1;
            }
        }
        return low;
    }
}
