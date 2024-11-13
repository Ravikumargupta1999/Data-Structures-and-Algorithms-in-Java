import java.util.HashMap;
import java.util.HashSet;

public class Video_9_Minimum_Window_Substring__II {
    public static int minWindow(String str1, String str2) {
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            set.add(ch);
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //acquire
            while (i < str1.length() - 1 && map.size() < set.size()) {
                i++;
                char ch = str1.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                f1 = true;
            }

            // release and collect
            while (j < i && map.size() == set.size()) {
                int potentialLength = i - j;
                if (potentialLength > ans)
                    ans = potentialLength;
                j++;
                char ch = str1.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
                f2 = true;
            }
            if (!f1 && !f2)
                break;
        }
        return ans;
    }
}
