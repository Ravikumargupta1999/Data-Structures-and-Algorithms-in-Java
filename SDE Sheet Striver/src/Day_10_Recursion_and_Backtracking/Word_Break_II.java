package Day_10_Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Word_Break_II {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        String[] wordDict = {"apple","pen","applepen","pine","pineapple"};
        List<String> list = new ArrayList<>();
        for (String word : wordDict)
            list.add(word);
        System.out.println(wordBreak(s,list));

    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict)
            set.add(word);
        wordBreak(s, 0,"", set, list);
        return list;
    }

    public static void wordBreak(String str, int index, String res, HashSet<String> set, List<String> list) {
        if (index == str.length()) {
            list.add(res.substring(0, res.length() - 1));
            return;
        }
        System.out.println(index+"  "+res+"  "+list);
        String left = "";
        for (int i = index; i < str.length(); i++) {

            left += str.charAt(i);

            if (set.contains(left)) {
                if (res.length() == 0) {
                    wordBreak(str, i + 1, left, set, list);
                } else {
                    wordBreak(str, i + 1, res + " " + left, set, list);
                }
            }
        }
    }
}
