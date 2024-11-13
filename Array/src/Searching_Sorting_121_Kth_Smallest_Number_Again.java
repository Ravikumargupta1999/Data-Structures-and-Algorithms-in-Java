import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Searching_Sorting_121_Kth_Smallest_Number_Again {
    public static void main(String args[]) throws Exception {


        Scanner s = new Scanner(System.in);

        int test = s.nextInt();
        while (test-- > 0) {
            int N;
            int Q;
            N = s.nextInt();
            Q = s.nextInt();


            int[][] range = new int[N][2];
            for (int i = 0; i < range.length; i++) {
                range[i][0] = s.nextInt();
                range[i][1] = s.nextInt();
            }
            range = mergeInterval(range);

            for (int[] temp : range){
                System.out.println(Arrays.toString(temp));
            }


            while (Q-- > 0) {
                int k = s.nextInt();
                printKthSmallestNumberAgain(k, range);
            }
        }
    }

    public static void printKthSmallestNumberAgain(int k, int[][] range) {
        int ans = -1;

        for (int i = 0; i < range.length; i++) {
            int a = range[i][0];
            int b = range[i][1];

            if (b - a + 1 >= k) {
                ans = a + k - 1;
                break;
            } else {

                k = k - (b - a + 1);
            }
        }
        System.out.println(ans);
    }

    static int[][] mergeInterval(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        ArrayList<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        list.add(new int[]{start, end});
        int[][] range = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++)
            range[i] = list.get(i);
        return range;
    }
}
