import java.util.HashMap;

public class Video_18_Count_of_Substrings_with_at_most_K_Distinct_Character {
    int solution(String str, int k) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {

            while (i < str.length() - 1) {

                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() <= k) {
                    ans +=(i-j);
                }
                else
                    break;
            }
            if( i == str.length()-1 && map.size() <= k)
                break;
            while (j < i) {

                j++;
                char ch = str.charAt(j);
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch) - 1);
                if (map.size() > k)
                    continue;
                else {
                    ans = ans + (i - j);
                    break;
                }
            }


        }
        return ans;
    }
}
