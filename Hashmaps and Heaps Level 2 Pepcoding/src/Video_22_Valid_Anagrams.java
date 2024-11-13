import java.util.HashMap;
import java.util.Scanner;

public class Video_22_Valid_Anagrams {
    // https://leetcode.com/problems/valid-anagram/submissions/
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        for (char ch : t.toCharArray()){
            if(!map.containsKey(ch))
                return false;
            else {
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else {
                    map.put(ch,map.get(ch)-1);
                }
            }
        }
        return map.size() == 0;
    }
}
