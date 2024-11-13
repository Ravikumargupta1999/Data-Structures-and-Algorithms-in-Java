import java.util.HashMap;
// https://leetcode.com/problems/4sum-ii/
public class Video_45_Quadruple_Sum_2 {
    public int fourSumCount(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e1 : arr1) {
            for (int e2 : arr2) {
                map.put(e1 + e2, map.getOrDefault(e1 + e2, 0) + 1);
            }
        }
        int target = 0;
        int count = 0;
        for (int e1 : arr3) {
            for (int e2 : arr4) {
                count += map.getOrDefault(target - (e1 + e2), 0);
            }
        }
        return count;
    }
}
