import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/anagram-of-string/1?page=12&company[]=Amazon&sortBy=submissions
public class Practice_4_Anagram_Of_String {

    public int remAnagrams(String s1, String s2) {
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch : s2.toCharArray()) {
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) - 1);
            else
                map.put(ch, -1);
        }

        int count = 0;

        for (Character ch : map.keySet()) {
            count += Math.abs(map.get(ch));
        }
        return count;
    }
}
