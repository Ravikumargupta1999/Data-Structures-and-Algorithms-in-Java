import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//https://practice.geeksforgeeks.org/contest/microsoft-online-coding-assesment-8/problems/#
public class S_Stack_Queue_312_Merge_Overlapping_Interval {
    class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[][] overlappedInterval(int[][] Intervals) {
        ArrayList<Pair> arrayList = new ArrayList<>();

        for (int i = 0; i < Intervals.length; i++) {
            arrayList.add(new Pair(Intervals[i][0], Intervals[i][1]));
        }
        Collections.sort(arrayList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.start - o2.start;
            }
        });

        ArrayList<Pair> ans = new ArrayList<>();
        int left = arrayList.get(0).start;
        int right = arrayList.get(0).end;
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i).start <= right) {
                right = Math.max(right, arrayList.get(i).end);
            } else {
                ans.add(new Pair(left, right));
                left = arrayList.get(i).start;
                right = arrayList.get(i).end;
            }
        }
        ans.add(new Pair(left, right));

        int[][] res = new int[ans.size()][2];
        int i = 0;
        for (Pair p : ans) {
            res[i][0] = p.start;
            res[i++][1] = p.end;
        }
        return res;
    }
    // https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1/#
    public int[][] overlappedInterval1(int[][] Intervals) {
        Arrays.sort(Intervals, (a, b) -> {
            return a[0] - b[0];
        });
        ArrayList<int[]> arrayList = new ArrayList<>();
        int l = Intervals[0][0];
        int r = Intervals[0][1];
        for (int i = 0; i < Intervals.length; i++) {
            if (Intervals[i][0] <= r) {
                r = Math.max(r, Intervals[i][1]);
            } else {
                arrayList.add(new int[]{l, r});
                l = Intervals[i][0];
                r = Intervals[i][1];
            }
        }
        arrayList.add(new int[]{l, r});
        int[][] res = new int[arrayList.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = arrayList.get(i)[0];
            res[i][1] = arrayList.get(i)[1];
        }
        return res;
    }
}
