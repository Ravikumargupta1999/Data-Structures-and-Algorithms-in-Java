import java.util.HashMap;
import java.util.HashSet;

public class String_88_Smallest_Window_Substring {



    // https://www.youtube.com/watch?v=e1HlptlipB0
    //https://leetcode.com/problems/minimum-window-substring/
    // https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1#
    //  // GFG TLE
    public String minWindow1(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (char ch : t.toCharArray())
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        int matchCount = 0;
        int desiredMatchCount = t.length();

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        String res = "";
        while (true) {

            boolean f1 = false;
            boolean f2 = false;

            // Acquire Characters

            while (i < s.length() - 1 && matchCount < desiredMatchCount) {
                i++;
                char ch = s.charAt(i);

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (target.containsKey(ch) && map.get(ch) <= target.get(ch))
                    matchCount++;

                f1 = true;
            }

            // Collect answer and release character

            while (j < i && matchCount == desiredMatchCount) {
                String currRes = s.substring(j + 1, i + 1);

                if (res.length() == 0 || currRes.length() < res.length())
                    res = currRes;

                j++;

                char ch = s.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (target.containsKey(ch) && map.get(ch) < target.get(ch))
                    matchCount--;
                if (map.get(ch) == 0)
                    map.remove(ch);
                f2 = true;
            }
            if(!f1 && !f2)
                break;
        }
        return res;
    }


    // Update using length while collecting string
    // https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1#
    public static String smallestWindow(String s, String p) {
        int ans = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int matchCount = 0;
        int desiredMatchCount = p.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //acquire
            while (i < s.length() - 1 && matchCount < desiredMatchCount) {
                i++;
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                if (map1.getOrDefault(ch, 0) <= map.getOrDefault(ch, 0)) {
                    matchCount++;
                }
                f1 = true;
            }
            while (j < i && matchCount == desiredMatchCount) {
                int pans = i - j;
                if (ans == Integer.MAX_VALUE || pans < ans) {
                    ans = pans;
                    start = j;
                    end = i;
                }
                j++;
                char ch = s.charAt(j);
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }
                if (map1.getOrDefault(ch, 0) < map.getOrDefault(ch, 0)) {
                    matchCount--;
                }
                f2 = true;
            }
            if (!f1 && !f2)
                break;
        }

        if (desiredMatchCount <= end - start)
            return s.substring(start + 1, end + 1);
        else
            return "-1";

    }

    // https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1#
    public String minWindow(String s, String t) {
        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int matchCount = 0;
        int desiredMatchCount = t.length();

        HashMap<Character, Integer> map1 = new HashMap<>();

        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //acquire
            while (i < s.length() - 1 && matchCount < desiredMatchCount) {
                i++;
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
                    matchCount++;
                }
                f1 = true;
            }

            while (j < i && matchCount == desiredMatchCount) {
                String pans = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || pans.length() < ans.length()) {
                    ans = pans;
                }
                j++;
                char ch = s.charAt(j);
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
        if (ans.length() == 0)
            return "-1";
        return ans;
    }

    // https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1#
    public int findSubString( String s) {
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int smallestLength = s.length() + 1;
        for (char ch : s.toCharArray())
            set.add(ch);
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < s.length() - 1 && map.size() < set.size()) {
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                f1 = true;
            }

            while (j < i && map.size() == set.size()) {
                smallestLength = Math.min(smallestLength, i - j);
                j++;
                char ch = s.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
                f2 = true;
            }
            if(!f1 && !f2)
                break;
        }
//        System.out.println(smallestLength);
        return smallestLength;
    }
}
