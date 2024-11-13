import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
//https://practice.geeksforgeeks.org/problems/k-closest-elements3619/1/?company[]=OYO%20Rooms&company[]=OYO%20Rooms&page=3&query=company[]OYO%20Roomspage3company[]OYO%20Rooms#

public class K_closest_elements {
    static int[] printKClosest(int[] arr, int n, int k, int x) {
        int index = -1;
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.difference != o2.difference)
                    return o1.difference - o2.difference;
                else
                    return o2.val - o1.val;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != x)
                pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
        }
        int i = 0;
        int temp = k;
        while (!pq.isEmpty() && temp-- > 0) {
            ans[i++] = pq.peek().val;
            pq.poll();
        }
        return ans;
    }

    static class Pair {
        int val;
        int difference;

        public Pair(int val, int difference) {
            this.val = val;
            this.difference = difference;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 10};
        System.out.println(Arrays.toString(printKClosest(arr, arr.length, 3, 4)));
    }
}
