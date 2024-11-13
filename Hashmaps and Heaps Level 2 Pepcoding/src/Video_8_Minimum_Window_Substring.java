import java.util.HashMap;

//https://leetcode.com/problems/minimum-window-substring/
public class Video_8_Minimum_Window_Substring {
    // https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1/
    public static String smallestWindow(String str1, String str2)
    {
        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int matchCount = 0;
        int desiredMatchCount = str2.length();

        HashMap<Character, Integer> map1 = new HashMap<>();

        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //acquire
            while (i < str1.length() - 1 && matchCount < desiredMatchCount) {
                i++;
                char ch = str1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
                    matchCount++;
                }
                f1 = true;
            }

            // release and collect
            while (j < i && matchCount == desiredMatchCount) {
                String pans = str1.substring(j + 1, i + 1);
                if (ans.length() == 0 || pans.length() < ans.length()) {
                    ans = pans;
                }
                j++;
                char ch = str1.charAt(j);
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }
                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    matchCount--;
                }
                f2 = true;
            }
            if (!f1 && !f2)
                break;
        }
        return ans.length() == 0 ? "-1" : ans;
    }

    // https://leetcode.com/problems/minimum-window-substring/submissions/
    public String minWindow(String str1, String str2) {
        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int matchCount = 0;
        int desiredMatchCount = str2.length();

        HashMap<Character, Integer> map1 = new HashMap<>();

        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //acquire
            while (i < str1.length() - 1 && matchCount < desiredMatchCount) {
                i++;
                char ch = str1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
                    matchCount++;
                }
                f1 = true;
            }

            // release and collect
            while (j < i && matchCount == desiredMatchCount) {
                String pans = str1.substring(j + 1, i + 1);
                if (ans.length() == 0 || pans.length() < ans.length()) {
                    ans = pans;
                }
                j++;
                char ch = str1.charAt(j);
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }
                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    matchCount--;
                }
                f2 = true;
            }
            if (!f1 && !f2)
                break;
        }
        return ans;
    }
}
