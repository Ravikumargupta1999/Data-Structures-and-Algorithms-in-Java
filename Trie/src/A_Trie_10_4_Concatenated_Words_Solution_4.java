import java.util.*;
// https://www.youtube.com/watch?v=6s1Y3zSIMbI
// https://leetcode.com/problems/concatenated-words/
public class A_Trie_10_4_Concatenated_Words_Solution_4 {
    // Accepted
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String str : words) {
            set.add(str);
        }
        for (String s : words) {
            set.remove(s);
            if (canForm(s, set))
                res.add(s);
            set.add(s);
        }
        return res;
    }

    public boolean canForm(String word, Set<String> set) {
        if (set.size() == 0)
            return false;
        int n = word.length();
        if (n == 0)
            return false;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j])
                    continue;
                if (set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
