package Day_4_Arrays_;

import java.util.ArrayList;
import java.util.HashMap;
public class Count_SubArrays_With_Given_XOR {
    // https://www.youtube.com/watch?v=lO9R5CaGRPY
    // https://www.codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        int count = 0;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            xor = xor ^ arr.get(i);
            if (xor == x)
                count++;
            if (map.get(xor ^ x) != null) count += map.get(xor ^ x);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
