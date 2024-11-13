import java.util.*;

public class A_Trie_405_Print_Anagrams_Together {
    public List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> res = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();

        for (String s : string_list) {
            HashMap<Character, Integer> map1 = new HashMap<>();
            for (char ch : s.toCharArray())
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
            if (!map.containsKey(map1))
                map.put(map1, new ArrayList<>());
            map.get(map1).add(s);
        }
        for (HashMap<Character, Integer> list : map.keySet()) {
            res.add(map.get(list));
        }
        Collections.sort(res, (a, b) -> {
            return b.size() - a.size();
        });
        return res;
    }



}
