package Time_And_Space_Complexity;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class Pivot_In_Rotated_And_Sorted_Array {
    public int findMin(int[] A) {
        int l = 0;
        int h = A.length - 1;
        while (l < h) {
            int mid = (h + l) / 2;
            if (A[mid] < A[h]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return A[h];
    }
}
