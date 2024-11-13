package Biweekly_Contest_74;

import java.util.HashMap;

public class Divide_Array_Into_Equal_Pairs {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key : map.keySet()) {
            if (map.get(key) % 2 != 0)
                return false;
        }
        return true;
    }
}
