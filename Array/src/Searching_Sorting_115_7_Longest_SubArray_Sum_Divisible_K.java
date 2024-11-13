import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1#

public class Searching_Sorting_115_7_Longest_SubArray_Sum_Divisible_K {
    public static int solution(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int rem = 0;
        int ans = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            rem = sum % k;
            if (rem < 0)
                rem += k;
            if (map.containsKey(rem)) {
                int idx = map.get(rem);
                int len = i - idx;
                if (len > ans)
                    ans = len;

            } else
                map.put(rem, i);

        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
