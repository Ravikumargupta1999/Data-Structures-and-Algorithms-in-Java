import java.util.HashMap;
import java.util.HashSet;

public class Video_46_Frog_Jump {
    // https://leetcode.com/problems/frog-jump/
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for (int i = 0; i < stones.length; i++) {
            int currentPos = stones[i];
            HashSet<Integer> jumps = map.get(currentPos);
            for (int jump : jumps) {
                int pos = currentPos + jump;
                if (pos == stones[stones.length - 1])
                    return true;
                if (map.containsKey(pos)) {
                    if (jump - 1 > 0)
                        map.get(pos).add(jump - 1);
                    map.get(pos).add(jump);
                    map.get(pos).add(jump + 1);
                }
            }
        }
        return false;
    }
}
