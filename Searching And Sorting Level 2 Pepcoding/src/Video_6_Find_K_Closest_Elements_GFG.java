import java.util.*;

// https://leetcode.com/problems/find-k-closest-elements/
public class Video_6_Find_K_Closest_Elements_GFG {
    // GFG wale us element ko nahi lena
    // leetcode mein usko bhi lena hai
//    https://practice.geeksforgeeks.org/problems/k-closest-elements3619/1#
//    If X is present in the array, then it need not be considered.
//    If there are two elements with the same difference with X, the greater element is given priority.
//    If sufficient elements are not present on the right side then take elements from left and vice versa.
//

    class Pair {
        int val;
        int difference;

        public Pair(int val, int difference) {
            this.val = val;
            this.difference = difference;
        }
    }
    int[] printKClosest(int[] arr, int n, int k, int x) {
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
            if(arr[i] == x)
                continue;
            pq.add(new Pair(arr[i], Math.abs(x - arr[i])));
        }
        int i = 0;
        int temp = k;
        while (!pq.isEmpty() && temp-- > 0) {
            ans[i++] = pq.peek().val;
            pq.poll();
        }
        int[] al = new int[ans.length];
        for (int j = 0; j < ans.length; j++) {
            al[j] = ans[j];
        }
        // Arrays.sort(al);
        return al;
    }


}
//[0,0,1,2,3,3,4,7,7,8]
//        3
//        5