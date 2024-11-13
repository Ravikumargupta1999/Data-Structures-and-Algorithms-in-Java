// Done
public class Matrix_46_Median_in_a_row_wise_sorted_Matrix {
    // https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1#
    // https://www.youtube.com/watch?v=63fPPOdIr2c&t=1539s
    private int countSmallerThanMid(int[] row, int mid) {
        int l = 0, h = row.length - 1;
        while (l <= h) {
            int md = (l + h) >> 1;
            if (row[md] <= mid) {
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return l;
    }

    int median(int matrix[][], int r, int c) {
        int low = 0;
        int high = 20001;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int cnt = 0;
            for (int[] mat : matrix) {
                cnt += countSmallerThanMid(mat, mid);
            }

            if (cnt <= (r * c) / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
