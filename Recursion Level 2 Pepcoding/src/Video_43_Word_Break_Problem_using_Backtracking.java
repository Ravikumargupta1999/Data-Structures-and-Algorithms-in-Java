import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


// https://www.youtube.com/watch?v=LmHWIsBQBU4&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=16

public class Video_43_Word_Break_Problem_using_Backtracking {

    // https://leetcode.com/problems/word-break-ii/submissions/
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for (String str : wordDict)
            dict.add(str);
        List<String> list = new ArrayList<>();
        wordBreak(s, "", dict,list);
        return list;
    }
    // https://practice.geeksforgeeks.org/problems/word-break-part-23249/1
    static List<String> wordBreak(int n, List<String> wordDict, String s)
    {
        HashSet<String> dict = new HashSet<>();
        for (String str : wordDict)
            dict.add(str);
        List<String> list = new ArrayList<>();
        wordBreak(s, "", dict,list);
        return list;
    }

    public static void wordBreak(String str, String ans, HashSet<String> dict,List<String> list) {
        if (str.length() == 0) {
           list.add(ans.substring(0,ans.length()-1));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (dict.contains(left)) {
                wordBreak(str.substring(i + 1), ans + left + " ", dict,list);
            }
        }
    }
}
