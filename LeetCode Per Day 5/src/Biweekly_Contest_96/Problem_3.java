package Biweekly_Contest_96;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem_3 {
    public static void main(String[] args) {
        int[] nums_1 = {1, 0, 3, 2};
        int[] nums_2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(nums_1, nums_2, k));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long max = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            pq.add(arr[i][0]);
            sum += arr[i][0];
            if (pq.size() < k)
                continue;
            if (pq.size() > k) {

                int temp = pq.poll();


                sum -= temp;

            }

            max = Math.max(max, sum * (long) arr[i][1]);

        }
        return max;
    }

    public long maxScoreO(int[] speed, int[] efficiency, int k) {
        int n = speed.length;
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i)
            ess[i] = new int[]{efficiency[i], speed[i]};
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = 0, sumS = 0;
        for (int[] es : ess) {
            pq.add(es[1]);
            sumS = (sumS + es[1]);
            if (pq.size() > k) sumS -= pq.poll();
            if (pq.size() == k) res = Math.max(res, (sumS * es[0]));
        }
        return res;
    }

    public int alternateDigitSum(int n) {
        boolean f = true;
        int s = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (f)
                s += (list.get(i));
            else
                s -= (list.get(i));
            f = !f;
        }
        return s;
    }

    public int[][] sortTheStudents(int[][] score, int k) {

        Arrays.sort(score, (a, b) -> {
            return b[k] - a[k];
        });
        return score;
    }

    public boolean makeStringsEqual(String start, String end) {

        int ones_ = 0;
        int zeros_ = 0;
        int count_one_zero_ = start.length();
        for (int i = 0; i < start.length(); i++) {

            if (start.charAt(i) != end.charAt(i)) {
                if (start.charAt(i) == '1')
                    ones_++;
                else
                    zeros_++;
            } else {
                if (start.charAt(i) == '0')
                    count_one_zero_--;
            }
        }
        if (ones_ == 0 && count_one_zero_ == 0)
            return true;
        if (ones_ == count_one_zero_ || count_one_zero_==zeros_)
            return false;
        return true;


    }
}
