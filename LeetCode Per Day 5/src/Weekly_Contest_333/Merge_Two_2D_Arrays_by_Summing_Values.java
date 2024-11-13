package Weekly_Contest_333;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Merge_Two_2D_Arrays_by_Summing_Values {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] num : nums1) {
            map.put(num[0], num[1]);
        }
        for (int[] num : nums2) {
            if (map.containsKey(num[0]))
                map.put(num[0], map.get(num[0]) + num[1]);
            else
                map.put(num[0], num[1]);
        }
        int i = 0;
        int[][] res = new int[map.size()][2];
        for (int key : map.keySet()) {
            res[i] = new int[]{key, map.get(key)};
            i++;
        }
        Arrays.sort(res,(a,b)->{
            return a[0]-b[0];
        });
        return res;
    }
}
