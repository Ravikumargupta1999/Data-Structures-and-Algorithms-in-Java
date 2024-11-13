import java.util.Scanner;

public class Array_41_Median_Of_Two_Sorted_Array_2 {
    // https://www.youtube.com/watch?v=LPFhl65R7ww&t=1109s
    // https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/0/?category%5B%5D=Searching&page=2&query=category%5B%5DSearchingpage2
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = s.nextInt();
        }
        System.out.println("");
        int m = s.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = s.nextInt();
        }
        double value = medianOfArrays(n, m, arr1, arr2);

        System.out.println(value);
    }

    public static double medianOfArrays(int n, int m, int[] arr1, int[] arr2) {
        if (n > m)
            return (double) medianOfArrays(m, n, arr2, arr1);

        int low = 0;
        int high = n;
        while (low <= high) {
            int partition_x = (low + high) / 2;
            int partition_y = (n + m + 1) / 2 - partition_x;
            double max_left_x = (partition_x == 0) ? (Integer.MIN_VALUE) : arr1[partition_x - 1];
            double min_right_x = (partition_x == n) ? (Integer.MAX_VALUE) : arr1[partition_x];

            double max_Left_y = (partition_y == 0) ? Integer.MIN_VALUE : arr2[partition_y - 1];
            double min_right_y = (partition_y == m) ? Integer.MAX_VALUE : arr2[partition_y];

            if (max_left_x <= min_right_y && max_Left_y <= min_right_x) {

                if ((n + m) % 2 == 0) {
                    return (double) (Math.max(max_left_x, max_Left_y) + Math.min(min_right_x, min_right_y)) / 2;
                } else {
                    return (double) Math.max(max_left_x, max_Left_y);
                }
            } else if (max_left_x > min_right_y) { //we are too far on right side for partitionX. Go on left side.
                high = partition_x - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partition_x + 1;
            }
        }
        return 0;
    }
}
