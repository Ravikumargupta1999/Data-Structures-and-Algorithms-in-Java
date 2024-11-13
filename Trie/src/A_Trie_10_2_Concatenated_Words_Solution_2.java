import java.util.*;

public class A_Trie_10_2_Concatenated_Words_Solution_2 {
    // Time limit exceed
    int min = Integer.MAX_VALUE;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String str : words) {
            if(str.length() == 0)
                continue;
            min = Math.min(min, str.length());
            set.add(str);
        }
        for(String str : words){
            if(canForm(str,set))
                res.add(str);
        }
        return res;
    }

    public boolean canForm(String word, Set<String> set) {
        for (int i = min; i < word.length() - min + 1; i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (set.contains(left)) {
                if (set.contains(right) || canForm(right, set))
                    return true;
            }
        }
        return false;
    }
}
