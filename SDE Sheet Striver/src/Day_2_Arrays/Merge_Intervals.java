package Day_2_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        list.add(new int[]{start, end});

//         int[][] res = new int[list.size()][2];
//         int i = 0;
//         for (int[] arr : list) {
//             res[i++] = arr;
//         }
//         return res;
        return list.toArray(new int[list.size()][2]);
    }
}
