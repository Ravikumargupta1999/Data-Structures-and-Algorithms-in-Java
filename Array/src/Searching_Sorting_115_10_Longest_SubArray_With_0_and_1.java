import java.util.HashMap;

public class Searching_Sorting_115_10_Longest_SubArray_With_0_and_1 {

    // https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
    public static int maxlen(int[] arr, int n) {
        int ans = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum += -1;
            } else if (arr[i] == 1) {
                sum += 1;
            }
            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                if (ans < len)
                    ans = len;
            } else
                map.put(sum, i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
