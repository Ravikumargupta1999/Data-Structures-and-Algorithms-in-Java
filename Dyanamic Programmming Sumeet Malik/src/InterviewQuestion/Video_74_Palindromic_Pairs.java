package InterviewQuestion;

import java.sql.Array;
import java.util.*;

public class Video_74_Palindromic_Pairs {
    // https://www.youtube.com/watch?v=ewNE1UbjmJ8
    // https://leetcode.com/problems/palindrome-pairs/submissions/
    // https://practice.geeksforgeeks.org/problems/palindrome-pairs/0?fbclid=IwAR0OHqaTufEv2dMEGMBwGjY4wxVVChCepetdlTSxbePLa8J5Umv60WodZB0
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        // empty case

        if (map.containsKey("")) {
            int blankIndex = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i != blankIndex && isPalindrome(words[i])) {
                    res.add(Arrays.asList(blankIndex, i));
                    res.add(Arrays.asList(i, blankIndex));
                }
            }
        }

        // reflection case
        for (int i = 0; i < words.length; i++) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            Integer reversedIndex = map.get(reversed);
            if(reversedIndex != null && reversedIndex != i){
                res.add(Arrays.asList(i,reversedIndex));
            }

        }

        // Tricky case
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            for (int cut = 1; cut < curr.length(); cut++) {
                String left = curr.substring(0,cut);
                String right = curr.substring(cut);
                if(isPalindrome(left)){
                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reversedRight))
                    {
                        res.add(Arrays.asList(map.get(reversedRight),i));
                    }
                }
                if(isPalindrome(right)){
                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(reversedLeft)){
                        res.add(Arrays.asList(i,map.get(reversedLeft)));
                    }
                }
            }
        }
        return res;
    }

    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }


}
