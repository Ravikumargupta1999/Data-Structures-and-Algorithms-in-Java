import java.util.HashMap;
// https://leetcode.com/problems/isomorphic-strings/
// https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1/#
public class Video_25_Isomorphic_Strings {
    public boolean isIsomorphic(String str1, String str2) {
        return str1.length() == str2.length() && check(str1, str2) && check(str2, str1);
    }

    boolean check(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

}
