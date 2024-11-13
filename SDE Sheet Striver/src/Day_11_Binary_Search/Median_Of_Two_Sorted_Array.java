package Day_11_Binary_Search;

public class Median_Of_Two_Sorted_Array {
    // https://www.youtube.com/watch?v=LPFhl65R7ww
    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        if(n>m)
            return (double)  findMedianSortedArrays(arr2,arr1);
        int x = n;
        int y = m;
        int low = 0;
        int high = x;
        while (low<=high)
        {
            int partition_x = (low + high)/2;
            int partition_y = (x + y + 1)/2 - partition_x;
            double max_left_x = (partition_x == 0) ? (Integer.MIN_VALUE) : arr1[partition_x-1];
            double min_right_x = (partition_x == x) ? (Integer.MAX_VALUE) : arr1[partition_x];

            double max_Left_y = (partition_y == 0) ? Integer.MIN_VALUE : arr2[partition_y - 1];
            double min_right_y = (partition_y == y) ? Integer.MAX_VALUE : arr2[partition_y];

            if (max_left_x<= min_right_y && max_Left_y <= min_right_x) {

                if ((x + y) % 2 == 0) {
                    return (double) (Math.max(max_left_x, max_Left_y) + Math.min(min_right_x, min_right_y))/2;
                }
                else {
                    return (double) Math.max(max_left_x, max_Left_y);
                }
            }
            else if (max_left_x > min_right_y) { //we are too far on right side for partitionX. Go on left side.
                high = partition_x - 1;
            }
            else { //we are too far on left side for partitionX. Go on right side.
                low = partition_x + 1;
            }


        }
        return 0;
    }
}
