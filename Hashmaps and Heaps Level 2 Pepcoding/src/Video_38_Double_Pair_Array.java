import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/array-of-doubled-pairs/
public class Video_38_Double_Pair_Array {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Integer[] ar = new Integer[arr.length];
        for (int i = 0; i < ar.length; i++)
            ar[i] = arr[i];
        Arrays.sort(ar, (a, b) -> {
            return Math.abs(a) - Math.abs(b);
        });
        for (Integer ele : ar) {
            if (map.get(ele) == 0)
                continue;
            if (map.getOrDefault(2 * ele, 0) == 0)
                return false;
            map.put(ele, map.get(ele) - 1);
            map.put(2 * ele, map.get(2 * ele) - 1);
        }
        return true;
    }
}
