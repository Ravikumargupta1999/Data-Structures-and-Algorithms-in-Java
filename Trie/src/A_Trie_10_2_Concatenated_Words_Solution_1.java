import java.util.*;

public class A_Trie_10_2_Concatenated_Words_Solution_1 {
    // Solution 1
    // Time Limit Exceed
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for(String str : words){
            if(canForm(str,set))
                res.add(str);
        }
        return res;
    }
    public boolean canForm(String word,Set<String> set)
    {
        for(int i=1;i<word.length();i++)
        {
            String left = word.substring(0,i);
            String right = word.substring(i);
            if(set.contains(left)){
                if(set.contains(right) || canForm(right,set))
                    return true;
            }
        }
        return false;
    }
}
