import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Video_50_Permutations {
    // https://leetcode.com/problems/permutations/submissions/
    public List<List<Integer>> permute(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
//        System.out.println(map);
        generateWords(1, arr.length, map, new ArrayList<>());
//        Collections.sort(ans);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    public void generateWords(int cs, int ts, HashMap<Integer, Integer> map, List<Integer> al) {

        if (cs > ts) {
            ans.add(new ArrayList<>(al));
            return;
        }
        for (int ch : map.keySet()) {
            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                al.add(ch);
                generateWords(cs + 1, ts, map, al);
                al.remove(al.size() - 1);
                map.put(ch, map.get(ch) + 1);
            }
        }
    }
}
