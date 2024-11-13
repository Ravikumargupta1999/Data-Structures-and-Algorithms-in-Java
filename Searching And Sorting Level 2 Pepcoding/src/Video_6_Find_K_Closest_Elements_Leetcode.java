import java.util.*;

// https://leetcode.com/problems/find-k-closest-elements/
public class Video_6_Find_K_Closest_Elements_Leetcode {
    static class Pair1 {
        int val;
        int difference;

        public Pair1(int val, int difference) {
            this.val = val;
            this.difference = difference;
        }
    }
    public static List<Integer> findClosestElement1(int[] arr, int k, int x) {
        int n = arr.length;
        int index = -1;
        int[] ans = new int[k];
        PriorityQueue<Pair1> pq = new PriorityQueue<>(new Comparator<Pair1>() {
            @Override
            public int compare(Pair1 o1, Pair1 o2) {
                if (o1.difference != o2.difference)
                    return o2.difference - o1.difference;
                else
                    return o1.val - o2.val;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.add(new Pair1(arr[i], Math.abs(x - arr[i])));
            } else {
                if (pq.peek().difference > Math.abs(x - arr[i])) {
                    pq.poll();
                    pq.add(new Pair1(arr[i], Math.abs(x - arr[i])));
                }
            }
        }
        List<Integer> al = new ArrayList<>();
        while (!pq.isEmpty())
            al.add(pq.poll().val);
        Collections.sort(al);
        return al;
    }
}
