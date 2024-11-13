import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
// https://www.youtube.com/watch?v=DwdWafLsGm0&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=12
// https://practice.geeksforgeeks.org/problems/pallindrome-patterns0809/1/
public class Video_40_Palindromic_Permutations {
    public static void generatePalindromicPermutations(int cs, int ts, HashMap<Character, Integer> freMap, Character oddChar, String asf, List<String> list) {
        if (cs > ts) {
            String rev = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }
            String res = asf;
            if (oddChar != null)
                res += oddChar;
            res += rev;
            list.add(res);
            return;
        }
        for (char ch : freMap.keySet()) {
            int freq = freMap.get(ch);
            if (freq > 0) {
                freMap.put(ch, freq - 1);
                generatePalindromicPermutations(cs + 1, ts, freMap, oddChar, asf + ch, list);
                freMap.put(ch, freq);
            }
        }
    }

    public List<String> all_palindromes(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Character odd = null;
        int odds = 0;
        int len = 0;
        for (char ch : map.keySet()) {
            int freq = map.get(ch);
            if (freq % 2 == 1) {
                odd = ch;
                odds++;
            }
            map.put(ch, freq / 2);
            len += (freq / 2);
        }

        if (odds > 1) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        generatePalindromicPermutations(1, len, map, odd, "", list);
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i))
                    return a.charAt(i) - b.charAt(i);
            }
            return a.charAt(a.length() - 1) - b.charAt(b.length() - 1);
        });
        return list;
    }
}
