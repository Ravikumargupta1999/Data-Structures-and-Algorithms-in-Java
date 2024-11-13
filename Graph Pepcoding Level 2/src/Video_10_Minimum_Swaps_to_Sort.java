import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/minimum-swaps/1
public class Video_10_Minimum_Swaps_to_Sort {
    class Pair {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int minSwaps(int nums[]) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
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
