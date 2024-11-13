import java.util.ArrayList;
import java.util.HashMap;

public class Video_51_All_Unique_Permutations_of_an_array {
    // https://practice.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1#
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> al, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < al.size(); i++) {
            map.put(al.get(i), map.getOrDefault(al.get(i), 0) + 1);
        }
        generateWords(1, al.size(), map, new ArrayList<Integer>());
        return ans;
    }

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public static void generateWords(int cs, int ts, HashMap<Integer, Integer> map, ArrayList<Integer> al) {
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

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        ArrayList<Integer> al = new ArrayList<>();
        for (int v : arr)
            al.add(v);
        System.out.println(uniquePerms(al,al.size()));
    }
}
