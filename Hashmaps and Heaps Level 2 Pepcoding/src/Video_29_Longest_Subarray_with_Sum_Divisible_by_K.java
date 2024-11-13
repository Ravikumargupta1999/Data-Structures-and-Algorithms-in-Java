import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
public class Video_29_Longest_Subarray_with_Sum_Divisible_by_K {
    int longSubArrWthSumDivByK(int a[], int n, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            int rem = sum % k;
            if (rem < 0)
                rem += k;
            if (map.containsKey(rem)) {
                ans = Math.max(ans, i - map.get(rem));
            } else {
                map.put(rem, i);
            }
        }
        return ans;
    }

}
