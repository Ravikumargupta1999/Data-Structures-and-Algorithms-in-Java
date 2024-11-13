import java.util.*;

public class Backtracking_277_Word_Break_Part_I {
    public static int wordBreak(String str, ArrayList<String> dict) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < dict.size(); i++)
            set.add(dict.get(i));
        List<String> result = new ArrayList<>();
        wordBreakSolve(str, "", set, result);
        return result.size();
    }

    public static void wordBreakSolve(String str, String ans, HashSet<String> hs, List<String> result) {
        if (str.length() == 0) {
            result.add(ans.substring(0, ans.length() - 1));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (hs.contains(left)) {
                String right = str.substring(i + 1);
                wordBreakSolve(right, ans + left + " ", hs, result);
            }
        }
    }
}
