package HashMap_And_Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/common-elements5420/1
public class Common_Element {
    public static ArrayList<Integer> common_element(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int val : v1) {
            map1.put(val, map1.getOrDefault(val, 0) + 1);
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int val : v2) {
            map2.put(val, map2.getOrDefault(val, 0) + 1);
        }
        for (int val : map1.keySet()) {
            if (map2.containsKey(val)) {
                int min = Math.min(map1.get(val), map2.get(val));
                for (int i = 0; i < min; i++)
                    ans.add(val);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
