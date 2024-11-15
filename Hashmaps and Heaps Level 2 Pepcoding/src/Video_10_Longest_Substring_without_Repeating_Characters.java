import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1
public class Video_10_Longest_Substring_without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s.length() - 1) {
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == 2)
                    break;
                else {
                    int len = i - j;
                    if (len > ans)
                        ans = len;
                }
            }
            while (j < i) {
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1)
                    break;
            }
            if (!f1 && !f2)
                break;
        }
        return ans;
    }
}
