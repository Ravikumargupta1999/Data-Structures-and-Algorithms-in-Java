import java.util.HashMap;

// https://leetcode.com/problems/largest-substring-between-two-equal-characters/
// https://practice.geeksforgeeks.org/problems/maximum-number-of-characters-between-any-two-same-character4552/1
public class Video_50_Largest_Substring_Between_Two_Equal_Characters {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int curLen = i - map.get(ch) - 1;
                if (curLen > len)
                    len = curLen;
            } else
                map.put(ch, i);
        }
        return len;
    }
}
