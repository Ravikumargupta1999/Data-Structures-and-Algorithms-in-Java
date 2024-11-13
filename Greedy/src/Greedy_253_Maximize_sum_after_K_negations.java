import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Greedy_253_Maximize_sum_after_K_negations {
    // https://www.youtube.com/watch?v=8GDHYgbxTN4
    // https://practice.geeksforgeeks.org/problems/maximize-sum-after-k-negations1149/1
    public static long maximizeSum(long[] a, int n, int k) {
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (a[i] < 0 && k != 0) {
                a[i] = -a[i];
                k--;
            } else
                break;
        }
        Arrays.sort(a);
        if (k % 2 == 0)
            return sum(a);
        else {
            a[0] = -a[0];
            return sum(a);
        }
    }

    public static long sum(long[] a) {
        long s = 0;
        for (long v : a)
            s += v;
        return s;
    }

    // Using PriorityQueue
    public static long maximizeSum1(long[] a, int n, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (long v : a)
            queue.add(v);
        while (k-- > 0) {
            long v = queue.poll();
            v = -v;
            queue.add(v);
        }
        long sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] a = {-1, -2, -3, -4, -5};
        System.out.println(maximizeSum1(a, a.length, 10));
    }
}
