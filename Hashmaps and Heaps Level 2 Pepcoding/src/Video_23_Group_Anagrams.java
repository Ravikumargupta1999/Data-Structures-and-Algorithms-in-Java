import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Video_23_Group_Anagrams {
    // https://practice.geeksforgeeks.org/problems/print-anagrams-together/1#
    public List<List<String>> groupAnagrams(String[] str) {
        HashMap<HashMap<Character, Integer>, List<String>> res = new HashMap();
        for (String s1 : str) {
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (int i = 0; i < s1.length(); i++) {
                tempMap.put(s1.charAt(i), tempMap.getOrDefault(s1.charAt(i), 0) + 1);
            }
            if (res.containsKey(tempMap))
                res.get(tempMap).add(s1);
            else {
                List<String> al = new ArrayList<>();
                al.add(s1);
                res.put(tempMap, al);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (HashMap<Character, Integer> map : res.keySet()) {
            ans.add(res.get(map));
        }
        return ans;
    }
}
