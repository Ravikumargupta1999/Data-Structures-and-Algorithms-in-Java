import java.util.List;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1
// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/submissions/
// https://www.youtube.com/watch?v=aH-2Sig2H2Q
public class Heap_346_Smallest_range_in_K_lists {

//    public int[] smallestRange(List<List<Integer>> nums) {
//        int[] res = {-1000000, 1000000};
//        int max = Integer.MIN_VALUE;
//        int k = nums.size();
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
//        for (int i = 0; i < k; i++) {
//            max = Math.max(max, nums.get(i).get(0));
//            pq.add(new int[]{nums.get(i).get(0), 0, i});
//        }
//        while (true) {
//            int[] temp = pq.poll();
//            if (res[1] - res[0] > max - temp[0]) {
//                res[0] = temp[0];
//                res[1] = max;
//            }
//            temp[1]++;
//            if (temp[1] == nums.get(temp[2]).size())
//                break;
//            else {
//                max = Math.max(max, nums.get(temp[2]).get(temp[1]));
//                pq.add(new int[]{nums.get(temp[2]).get(temp[1]), temp[1], temp[2]});
//            }
//        }
//        return res;
//    }

    static int[] findSmallestRange(int[][] KSortedArray, int n, int k) {
        int[] ans = {-1000000, 1000000};
        int max = Integer.MIN_VALUE;

        // int[3] : 0 - val, 1 - index , 2 - ith array
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for (int i = 0; i < k; i++) {
            int val = KSortedArray[i][0];
            max = Math.max(val, max);
            pq.add(new int[]{val, 0, i});
        }
        while (true) {
            int[] rem = pq.poll();
            if (ans[1] - ans[0] > max - rem[0]) {
                ans[0] = rem[0];
                ans[1] = max;
            }
            rem[1]++;
            if (rem[1] == KSortedArray[rem[2]].length)
                break;
            else {
                max = Math.max(max, KSortedArray[rem[2]][rem[1]]);
                pq.add(new int[]{KSortedArray[rem[2]][rem[1]], rem[1], rem[2]});
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int arr[][] = {
                {4, 7, 9, 12, 15},
                {0, 8, 10, 14, 20},
                {6, 12, 16, 30, 50}
        };

        int k = arr.length;

        int[] result = findSmallestRange(arr, arr[0].length, k);
        System.out.println("[ " + result[0] + " , " + result[1] + " ]");
    }
}
