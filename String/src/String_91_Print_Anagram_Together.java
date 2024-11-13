import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Done

public class String_91_Print_Anagram_Together {
    // https://practice.geeksforgeeks.org/problems/print-anagrams-together/1#
    public static List<List<String>> groupAnagrams(String[] arr, int n) {
        HashMap<HashMap<Character, Integer>, List<String>> bmap = new HashMap<>();
        for (String str : arr) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            if (!bmap.containsKey(map)) {
                List<String> al = new ArrayList<>();
                al.add(str);
                bmap.put(map, al);
            } else {
                List<String> al = bmap.get(map);
                al.add(str);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> res : bmap.values()) {
            result.add(res);
        }
        return result;
    }

}
