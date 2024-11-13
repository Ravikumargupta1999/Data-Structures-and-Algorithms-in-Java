import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/1#
// Time Limit Exceed on GFG

// On leetcode par accept ho gya
// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class Video_13_Count_Substrings_with_K_Distinct_Characters {

    long subStrCount(String str, int k) {
        long ans = 0;
        if (k == 1)
            return solutionForK1(str);
        HashMap<Character, Integer> mapBig = new HashMap<>();
        HashMap<Character, Integer> mapSmall = new HashMap<>();
        int is = -1;
        int ib = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;
            while (ib < str.length() - 1) {
                f1 = true;
                ib++;
                char ch = str.charAt(ib);
                mapBig.put(ch, mapBig.getOrDefault(ch, 0) + 1);
                if (mapBig.size() == k + 1) {
                    removeInMap(mapBig, ch);
                    ib--;
                    break;
                }
            }

            while (is < ib) {
                f2 = true;
                is++;
                char ch = str.charAt(is);
                mapSmall.put(ch, mapSmall.getOrDefault(ch, 0) + 1);
                if (mapSmall.size() == k) {
                    removeInMap(mapSmall, ch);
                    is--;
                    break;
                }
            }
            while (j < is) {
                f3 = true;
                if (mapBig.size() == k && mapSmall.size() == k - 1)
                    ans += (ib - is);
                j++;
                char ch = str.charAt(j);
                removeInMap(mapBig, ch);
                removeInMap(mapSmall, ch);
                if (mapBig.size() < k || mapSmall.size() < k - 1)
                    break;
            }
            if (! f1&& !f2 && !f3 )
                break;
        }
        return ans;

    }

    long solutionForK1(String str) {
        long ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < str.length() - 1) {
                f1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() == 2) {
                    removeInMap(map, ch);
                    i--;
                    break;
                }

            }
            while (j < i) {
                f2 = true;
                if (map.size() == 1)
                    ans += (i - j);
                j++;
                char ch = str.charAt(j);
                removeInMap(map, ch);
                if (map.size() == 0) {
                    break;
                }
            }
            if (!f1 && !f2)
                break;
        }
        return ans;
    }

    void removeInMap(HashMap<Character, Integer> map, char ch) {
        if (map.get(ch) == 1)
            map.remove(ch);
        else
            map.put(ch, map.get(ch) - 1);

    }

    public static void main(String[] args) {
        String str = "";
        int k = 3;
        System.out.println(new Video_13_Count_Substrings_with_K_Distinct_Characters().subStrCount(str,k));
    }
}
