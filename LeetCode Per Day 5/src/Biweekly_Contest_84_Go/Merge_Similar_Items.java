package Biweekly_Contest_84_Go;

import java.util.*;

public class Merge_Similar_Items {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1)
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        for (int[] item : items2)
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        List<List<Integer>> ret = new ArrayList<>();
        int i = 0;
        for (int key : map.keySet()) {
            ret.add(new ArrayList<>());
            ret.get(i).add(key);
            ret.get(i).add(map.get(key));
            i++;
        }
        Collections.sort(ret, (a, b) -> {
            return a.get(0) - b.get(0);
        });
        return ret;
    }
}
