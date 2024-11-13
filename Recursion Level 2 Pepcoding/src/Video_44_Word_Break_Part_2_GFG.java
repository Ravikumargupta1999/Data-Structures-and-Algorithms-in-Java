import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.youtube.com/watch?v=jQJyWcRPEpE
// https://practice.geeksforgeeks.org/problems/word-break-part-23249/1#
public class Video_44_Word_Break_Part_2_GFG {
    static Map<String, List<String>> map = new HashMap<>();
    static List<String> wordBreak(int n, List<String> dict, String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        if (dict.contains(s))
            result.add(s);
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i );
            if (dict.contains(left)) {
                List<String> subList = wordBreak(n, dict, s.substring(i));
                for (String sen : subList) {
                    result.add(left + " " + sen);
                }
            }
        }
        map.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        int n = 5;
        String[] dict = {"cats", "cat", "and", "sand", "dog"};
        List<String> list = new ArrayList<>();
        for (String str : dict)
            list.add(str);
        System.out.println(wordBreak(n,list,s));
    }
}
