package Biweekly_Contest_61;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Find_Original_Array_From_Doubled_Array {
    public static void main(String[] args) {
        Thread.currentThread().setName("Suyog Ka thread");
        try {
            System.out.println(10/0);
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0)
            return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : changed)
            map.put(num, map.getOrDefault(num, 0) + 1);

        Arrays.sort(changed);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < changed.length; i++) {
            int curr = changed[i];

            if ((curr != 2 * curr && map.containsKey(curr) && map.containsKey(2 * curr)) || (curr == 2 * curr && map.containsKey(curr) && map.get(curr) > 1)) {
                list.add(curr);
                if (map.get(curr) == 1)
                    map.remove(curr);
                else
                    map.put(curr, map.get(curr) - 1);
                if (map.get(2 * curr) == 1)
                    map.remove(2 * curr);
                else
                    map.put(2 * curr, map.get(2 * curr) - 1);
            }
        }
        if (list.size() != changed.length / 2)
            return new int[]{};
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = list.get(i);
        return arr;
    }

}
