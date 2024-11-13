import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Video_57_Random_Pick_with_Blacklist {
    // https://leetcode.com/problems/random-pick-with-blacklist/submissions/
    HashMap<Integer, Integer> map;
    Random r;
    int top;

    public void Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        r = new Random();
        top = n - blacklist.length;
        HashSet<Integer> set = new HashSet<>();
        for (int val : blacklist)
            set.add(val);
        n--;
        for (int i = 0; i < blacklist.length; i++) {
            if (blacklist[i] < top) {
                while (set.contains(n))
                    n--;
                map.put(blacklist[i], n);
                n--;
            }
        }
    }

    public int pick() {
        int randidx = r.nextInt(top);
        if (map.containsKey(randidx))
            return map.get(randidx);
        return randidx;
    }
}
