import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Video_14_Permutations_of_a_String {
    // https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1/#
    public List<String> find_permutation(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        generateWords(1, str.length(), map, "");
        Collections.sort(ans);
        return ans;
    }

    List<String> ans = new ArrayList<>();

    public void generateWords(int cs, int ts, HashMap<Character, Integer> map, String asf) {
        if (cs > ts) {
            ans.add(asf);
            return;
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
                generateWords(cs + 1, ts, map, asf + ch);
                map.put(ch, map.get(ch) + 1);
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        Video_14_Permutations_of_a_String a = new Video_14_Permutations_of_a_String();
        System.out.println(a.find_permutation(str));

    }
}
