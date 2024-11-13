import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class S_Stack_Queue_328_First_Negative_Integer_In_Every_Window_Of_Size_K {
    static class Pair {
        long val;
        int index;

        public Pair(long val, int index) {
            this.val = val;
            this.index = index;
        }

    }

    public static long[] printFirstNegativeInteger1(long[] arr, int n, int k) {
        long[] res = new long[n - k + 1];
        // instead of making pair class you can just store negative element index in queue
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>((a, b) -> {
            return a.index - b.index;
        });
        for (int i = 0; i < k - 1; i++) {
            if (arr[i] < 0) {
                priorityQueue.add(new Pair(arr[i], i));
            }
        }
        int j = 0;

        for (int i = k - 1; i <= n - k + 1; i++) {
            if (arr[i] < 0) {
                priorityQueue.add(new Pair(arr[i], i));
            }

            if (priorityQueue.isEmpty()) {
                res[j] = 0;
            } else {
                res[j] = priorityQueue.peek().val;
            }

            while (!priorityQueue.isEmpty() && priorityQueue.peek().index <= j)
                priorityQueue.poll();
            j++;
        }
        return res;

    }

    public static long[] printFirstNegativeInteger2(long[] arr, int n, int k) {
        long[] res = new long[n - k + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            if (arr[i] < 0) {
                queue.add(i);
            }
        }
        int j = 0;

        for (int i = k - 1; i < n; i++) {
            if (arr[i] < 0) {
                queue.add(i);
            }

            if (queue.isEmpty()) {
                res[j] = 0;
            } else {
                res[j] = arr[queue.peek()];
            }

            if(!queue.isEmpty() && queue.peek() <= j)
                queue.poll();
            j++;
        }
        return res;
    }

    // Brute Force
    // TC : O( n * K )
    // SC : O( 1 )
    public long[] printFirstNegativeInteger3(long[] arr, int k) {
        long[] result = new long[arr.length - k + 1];
        for (long l = 0; l < arr.length - k + 1; l++) {
            long i = l;
            for (long j = 0; j < k; j++) {
                if (arr[(int) i] < 0) {
                    result[(int) l] = arr[(int) i];
                    break;
                }
                i++;
            }
        }
        return result;
    }

    // https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#
    // https://www.youtube.com/watch?v=CYloJQ9B4Lw
    // Brute Force
    // TC : O( n  )
    // SC : O( K )
    public static long[] printFirstNegativeInteger4(long[] arr, int n, int k) {
        long[] ans = new long[n - k + 1];
        Queue<Long> queue = new LinkedList<>();
        int i = 0;
        int j = 0;
        int idx = 0;

        while (j < n) {
            if (arr[j] < 0)
                queue.add(arr[j]);
            if (j - i + 1 == k) {
                if (queue.isEmpty())
                    idx++;
                else
                    ans[idx++] = queue.peek();
                if (queue.size() > 0 && arr[i] == queue.peek()) {
                    queue.poll();
                }
                i++;
            }
            j++;
        }
        return ans;
    }

}
