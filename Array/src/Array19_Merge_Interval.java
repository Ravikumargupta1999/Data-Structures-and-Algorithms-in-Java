import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Array19_Merge_Interval {

    // https://leetcode.com/problems/merge-intervals/
    // https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1/#
    // https://www.youtube.com/watch?v=2JzRBPFYbKE&t=487s
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > end) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //    https://leetcode.com/problems/insert-interval/
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0)
            return new int[][]{{newInterval[0], newInterval[1]}};

        ArrayList<int[]> list = new ArrayList<>();

        int i = 0;

        while (i < intervals.length) {
            if (intervals[i][1] < newInterval[0]) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                i++;
            } else {
                break;
            }
        }
        if (i == n) {
            list.add(new int[]{newInterval[0], newInterval[1]});
            return getResult(list);
        }

        int start = Math.min(intervals[i][0], newInterval[0]);
        while (i < intervals.length) {

            if (intervals[i][0] > newInterval[1]) {

                list.add(new int[]{start, newInterval[1]});
                break;
            } else if (intervals[i][0] == newInterval[1] || intervals[i][1] >= newInterval[1]) {

                list.add(new int[]{start, intervals[i][1]});
                i++;
                break;
            } else {

                i++;
            }
        }
        if (intervals[n - 1][1] < newInterval[1]) {
            list.add(new int[]{start, newInterval[1]});
        }

        while (i < intervals.length) {
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        return getResult(list);
    }

    public static int[][] getResult(ArrayList<int[]> list) {
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
