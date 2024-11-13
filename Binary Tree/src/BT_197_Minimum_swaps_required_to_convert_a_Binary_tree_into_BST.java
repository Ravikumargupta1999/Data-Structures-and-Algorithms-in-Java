import java.util.ArrayList;
import java.util.Arrays;

public class BT_197_Minimum_swaps_required_to_convert_a_Binary_tree_into_BST {
    public static int minimumSwaps(ArrayList<Integer> arr, int n) {
        int[] num = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            num[i] = arr.get(i);
        }
        return minSwaps(num);
    }

    static class Pair {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    // https://practice.geeksforgeeks.org/problems/minimum-swaps/1/
    // https://www.youtube.com/watch?v=m-8_yQao-lI&t=44s
    public static int minSwaps(int[] num) {
        int n = num.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(num[i], i);
        }
        Arrays.sort(arr, (a, b) -> {
            return a.val - b.val;
        });
        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] || arr[i].idx == i)
                continue;
            int clen = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;
                clen++;
                j = arr[j].idx;
            }
            ans += (clen - 1);
        }
        return ans;

    }
}
