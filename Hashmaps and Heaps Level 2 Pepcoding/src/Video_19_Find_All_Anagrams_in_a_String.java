import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1#

public class Video_19_Find_All_Anagrams_in_a_String {
    int search(String p, String s) {
        if (p.length() > s.length())
            return 0;
        HashMap<Character, Integer> stringMap = new HashMap<>();
        HashMap<Character, Integer> patternMap = new HashMap<>();

        for (int i = 0; i < p.length(); i++)
            patternMap.put(p.charAt(i), patternMap.getOrDefault(p.charAt(i), 0) + 1);
        for (int i = 0; i < p.length(); i++)
            stringMap.put(s.charAt(i), stringMap.getOrDefault(s.charAt(i), 0) + 1);

        int i = p.length();
        int count = 0;
        while (i < s.length()) {
            if(compare(stringMap, patternMap))
                count++;
            char cha = s.charAt(i);
            stringMap.put(cha, stringMap.getOrDefault(cha,0)+1);
            char chr = s.charAt(i-p.length());
            if(stringMap.get(chr) == 1)
                stringMap.remove(chr);
            else
                stringMap.put(chr, stringMap.get(chr)-1);
            i++;
        }
        if(compare(stringMap, patternMap))
            count++;
        return count;
    }

    boolean compare(HashMap<Character, Integer> stringMap, HashMap<Character, Integer> patternMap) {
        for (char sch : stringMap.keySet()) {
            if(patternMap.containsKey(sch))
            {
                int a = stringMap.get(sch);
                int b = patternMap.get(sch);
                if(a != b)
                    return false;
            }
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Video_19_Find_All_Anagrams_in_a_String a = new Video_19_Find_All_Anagrams_in_a_String();
        String s = "abac", p = "ab";
        System.out.println(a.search(p, s));
    }
}
