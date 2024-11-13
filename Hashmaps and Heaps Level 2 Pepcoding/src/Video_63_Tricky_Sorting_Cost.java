import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/morning-assembly3038/0/#
public class Video_63_Tricky_Sorting_Cost {
    static int sortingCost(int n, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, map.get(val - 1) + 1);
                maxLen = Math.max(maxLen, map.get(val - 1) + 1);
            } else {
                map.put(val, 1);
                maxLen = Math.max(maxLen, 1);
            }
        }
        return n - maxLen;
    }
}
