import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class Video_19_Find_All_Anagrams_in_a_String_leetoode {
    boolean compare(HashMap<Character, Integer> stringMap, HashMap<Character, Integer> patternMap) {
        for (char sch : stringMap.keySet()) {
            if (patternMap.containsKey(sch)) {
                int a = stringMap.get(sch);
                int b = patternMap.get(sch);
                if (a != b)
                    return false;
            } else
                return false;

        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> al = new ArrayList<>();
        if (p.length() > s.length())
            return new ArrayList<>();
        HashMap<Character, Integer> stringMap = new HashMap<>();
        HashMap<Character, Integer> patternMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++)
            patternMap.put(p.charAt(i), patternMap.getOrDefault(p.charAt(i), 0) + 1);
        for (int i = 0; i < p.length(); i++)
            stringMap.put(s.charAt(i), stringMap.getOrDefault(s.charAt(i), 0) + 1);

        int i = p.length();

        while (i < s.length()) {
            if (compare(stringMap, patternMap)) {
                al.add(i - p.length());
            }
            char cha = s.charAt(i);
            stringMap.put(cha, stringMap.getOrDefault(cha, 0) + 1);
            char chr = s.charAt(i - p.length());
            if (stringMap.get(chr) == 1)
                stringMap.remove(chr);
            else
                stringMap.put(chr, stringMap.get(chr) - 1);
            i++;
        }
        if (compare(stringMap, patternMap)) {
            al.add(i - p.length());

        }
        return al;

    }

}
