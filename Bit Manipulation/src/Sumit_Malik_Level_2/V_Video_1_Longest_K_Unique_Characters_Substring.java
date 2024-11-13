package Sumit_Malik_Level_2;

import java.util.HashMap;

public class V_Video_1_Longest_K_Unique_Characters_Substring {

    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int length = 0;
        int n = s.length();
        int i = -1;
        int j = -1;

        while (true) {

            boolean f1 = false;

            boolean f2 = false;

            while (i < n - 1 && map.size() <= k) {

                f1 = true;
                i++;

                char ch = s.charAt(i);

                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
                if (map.size() == k) {
                    if (length < (i - j )) {
                        length = i - j;
                    }
                }
            }
            while (j < i && map.size() > k) {

                f2 = true;

                j++;

                char ch = s.charAt(j);

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0)
                    map.remove(ch);
            }

            if (!f1 && !f2)
                break;
        }
        return length == 0 ? -1 : length;
    }


}
