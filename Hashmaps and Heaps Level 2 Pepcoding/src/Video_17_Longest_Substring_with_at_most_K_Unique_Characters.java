import java.util.HashMap;

//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-substring-with-at-most-k-unique-characters-official/ojquestion
// https://www.codingninjas.com/codestudio/problems/longest-sub-string-with-at-most-k-distinct-characters_699944?leftPanelTab=1

public class Video_17_Longest_Substring_with_at_most_K_Unique_Characters {
    public int longestKSubStr(String s, int k) {
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
                if (map.size() <= k)
                    ans = Math.max(ans, i - j);
                else
                    break;
            }
            while (j < i) {
                f2 = true;
                j++;
                char ch = s.charAt(j);
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch) - 1);
                if (map.size() > k)
                    continue;
                else {
                    ans = Math.max(ans, i - j);
                    break;
                }
            }
            if (!f1 && !f2)
                break;
        }
        if (ans == 0)
            return -1;
        return ans;
    }
}
