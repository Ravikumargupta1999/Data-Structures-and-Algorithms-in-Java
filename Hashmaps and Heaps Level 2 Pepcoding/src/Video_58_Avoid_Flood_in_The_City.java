import java.util.HashMap;
import java.util.TreeSet;

public class Video_58_Avoid_Flood_in_The_City {
    // https://leetcode.com/problems/avoid-flood-in-the-city/submissions/
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dry = new TreeSet<>();
        int n = rains.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = rains[i];
            if (x == 0) {
                dry.add(i);
                ans[i] = 1;// 2/3/4
            } else {
                Integer id = lastRain.get(x);
                if (id == null) {
                    lastRain.put(x, i);
                } else {
                    Integer dryThisDay = dry.higher(id);
                    if (dryThisDay == null) {
                        return new int[0];
                    }
                    ans[dryThisDay] = x;
                    dry.remove(dryThisDay);
                    lastRain.put(x, i);
                }
                ans[i] = -1;
            }
        }
        return ans;
    }
}
