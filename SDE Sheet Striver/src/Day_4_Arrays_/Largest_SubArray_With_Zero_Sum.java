package Day_4_Arrays_;

import java.util.HashMap;

public class Largest_SubArray_With_Zero_Sum {
    int maxLen(int arr[], int n) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
