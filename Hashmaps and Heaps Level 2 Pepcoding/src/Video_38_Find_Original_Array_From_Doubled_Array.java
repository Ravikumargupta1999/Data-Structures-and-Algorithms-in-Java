import java.util.Arrays;
import java.util.HashMap;
// https://leetcode.com/problems/find-original-array-from-doubled-array/
public class Video_38_Find_Original_Array_From_Doubled_Array {
    public int[] findOriginalArray(int[] arr) {
        if(arr.length == 0 || arr.length % 2 != 0)
            return new int[]{};
        if(!canReorderDoubled(arr))
            return new int[]{};
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
        int[] ans = new int[arr.length/2];
        int j = 0;
        for (Integer ele : ar) {
            if (map.get(ele) == 0)
                continue;
            ans[j++] = ele;
            map.put(ele, map.get(ele) - 1);
            map.put(2 * ele, map.get(2 * ele) - 1);
        }
        return ans;

    }
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
