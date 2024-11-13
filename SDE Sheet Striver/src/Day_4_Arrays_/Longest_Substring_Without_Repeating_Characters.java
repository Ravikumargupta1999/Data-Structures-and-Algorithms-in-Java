package Day_4_Arrays_;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdbca"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int i = -1;
        int j = -1;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;

        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            // acquire

            while (i < s.length() - 1) {
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) > 1) {
                    break;
                }
                res = Math.max(res, map.size());
            }

            while (j < i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else {
                    map.put(ch,1);
                    break;
                }
            }


            if (!f1 && !f2) {
                break;
            }
        }
        return res;
    }
}
