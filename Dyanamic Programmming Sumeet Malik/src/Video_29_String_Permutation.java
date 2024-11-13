import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Video_29_String_Permutation {

    // Not Valid For Duplicate Character
    public List<String> find_permutation(String S) {
        List<String> list = new ArrayList<>();
        getPermutation(S, "", list);
        Collections.sort(list);
        return list;
    }

    public void getPermutation(String str, String res, List<String> list) {
        if (str.length() == 1) {
            list.add(res + str.charAt(0));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            getPermutation(left + right, res + "" + str.charAt(i), list);
        }
    }


    public List<String> find_permutation1(String str) {
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
}

