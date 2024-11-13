import java.util.ArrayList;

public class Leetcode_57_Insert_Interval {
    // https://leetcode.com/problems/insert-interval/submissions/
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {6, 9}};
        int[] newInterval = {7, 10};
        arr = insert(arr, newInterval);
        for (int[] interval : arr) {
            System.out.println(interval[0] + "   " + interval[1]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
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
