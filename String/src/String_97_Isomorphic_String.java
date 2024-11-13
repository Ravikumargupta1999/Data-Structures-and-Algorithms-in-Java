import java.util.HashMap;
import java.util.HashSet;


public class String_97_Isomorphic_String {

    // https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1#
    public static boolean areIsomorphic1(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (map.containsKey(ch1)) {
                if (map.get(ch1) == ch2)
                    continue;
                else
                    return false;
            } else {
                if (set.contains(ch2))
                    return false;
                map.put(ch1, ch2);
                set.add(ch2);
            }
        }
        return true;
    }


}
