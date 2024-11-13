import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/sub-array-sum-divisible-by-k2617/1
// https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class Video_30_SubArray_sum_divisible_by_K {

    long subCount(long[] arr, int n, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int rem = sum % k;
            if (rem < 0)
                rem += k;
            if (map.containsKey(rem)) {
                ans += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = {2, 2, 2, 2, 2, 2};
        int k = 2;
        Video_30_SubArray_sum_divisible_by_K a = new Video_30_SubArray_sum_divisible_by_K();
        System.out.println(a.subCount(arr, arr.length, k));
    }
}
