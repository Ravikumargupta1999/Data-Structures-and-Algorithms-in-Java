package Day_12_Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Merge_K_Sorted_List {

    // https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            int k1 = a[0];
            int ind1 = a[1];
            int k2 = b[0];
            int ind2 = b[1];
            return arr[a[0]][a[1]] - arr[b[0]][b[1]];
        });
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(new int[]{i,0});
        }
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            res.add(arr[temp[0]][temp[1]]);
            if(arr[temp[0]].length == temp[1]+1)
                continue;
            temp[1]++;
            queue.add(temp);
        }
        return res;
    }
}
