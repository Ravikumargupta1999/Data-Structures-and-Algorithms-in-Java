import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class String_91_Find_All_Anagrams_Leetcode {
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
    // https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
    // For gfg return size

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


    // Own Solution
    public List<Integer> findAnagrams1(String s, String p) {
        HashMap<Character, Integer> stringMap = new HashMap<>();
        HashMap<Character, Integer> patternMap = new HashMap<>();

        for (char ch : p.toCharArray())
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);

        int matchCount = 0;
        int desiredMatchCount = p.length();
        int i = -1;
        int j = -1;

        List<Integer> res = new ArrayList<>();
        while (true) {

            boolean f1 = false;
            boolean f2 = false;

            while (i < s.length() - 1 && matchCount < desiredMatchCount) {

                i++;

                char ch = s.charAt(i);
                stringMap.put(ch, stringMap.getOrDefault(ch, 0) + 1);

                if (patternMap.containsKey(ch) && stringMap.get(ch) <= patternMap.get(ch))
                    matchCount++;

                f1 = true;
            }

            while (j < i && matchCount == desiredMatchCount) {
                if (compare(stringMap, patternMap))
                    res.add(j + 1);
                j++;

                char ch = s.charAt(j);
                stringMap.put(ch, stringMap.get(ch) - 1);

                if (patternMap.containsKey(ch) && stringMap.get(ch) < patternMap.get(ch))
                    matchCount--;
                if (stringMap.get(ch) == 0)
                    stringMap.remove(ch);
                f2 = true;
            }
            if (!f1 && !f2)
                break;
        }
        return res;
    }


    static boolean compare(HashMap<Character, Integer> stringMap, HashMap<Character, Integer> patternMap) {
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



}
