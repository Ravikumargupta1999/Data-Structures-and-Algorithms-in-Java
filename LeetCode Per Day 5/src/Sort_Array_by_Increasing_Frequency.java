import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Sort_Array_by_Increasing_Frequency {
    public int[] frequencySort(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        Collections.sort(list, (a, b) -> {
            if(map.get(a) != map.get(b))
                return map.get(a) - map.get(b);
            return b-a;
        });
        int i = 0;
        for (int num : list)
            nums[i++] = num;
        return nums;
    }
}
