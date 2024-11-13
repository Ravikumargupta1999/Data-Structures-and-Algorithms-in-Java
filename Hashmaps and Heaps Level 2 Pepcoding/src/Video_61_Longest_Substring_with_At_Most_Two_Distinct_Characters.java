import java.util.HashMap;
import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-substring-with-at-most-two-distinct-characters/ojquestion
public class Video_61_Longest_Substring_with_At_Most_Two_Distinct_Characters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int dis = 0;
        int ans = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int freq = map.getOrDefault(s.charAt(i), 0);
            if (freq == 0)
                dis++;
            map.put(s.charAt(i), freq + 1);
            while (dis > 2) {
                freq = map.get(s.charAt(start));
                map.put(s.charAt(start), freq - 1);
                if (freq - 1 == 0)
                    dis--;
                start++;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {

        Scanner scn = new Scanner(System.in);

        int ans = lengthOfLongestSubstringTwoDistinct(scn.nextLine());
        System.out.println(ans);
    }
}
