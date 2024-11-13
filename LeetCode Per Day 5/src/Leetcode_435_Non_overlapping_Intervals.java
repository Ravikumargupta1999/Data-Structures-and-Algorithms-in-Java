import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode_435_Non_overlapping_Intervals {
    public static void main(String[] args) {
        int[][] arr = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        System.out.println(eraseOverlapIntervals(arr));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int prev = Integer.MIN_VALUE;
        int count = 0;
        for (int[] interval : intervals) {
            if (prev == Integer.MIN_VALUE) {
                prev = interval[1];
                continue;
            }

            if (interval[0] >= prev) {
                prev = interval[1];
            } else if (interval[0] <= prev && interval[1] <= prev) {
                count++;
                prev = interval[1];
                continue;
            } else {
                count++;
            }
        }
        return count;
    }
}
