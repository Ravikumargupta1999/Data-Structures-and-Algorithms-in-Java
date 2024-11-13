package InterviewQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Video_13_Match_Specific_Pattern {
// https://practice.geeksforgeeks.org/problems/match-specific-pattern/1

    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
    {
        ArrayList<String> res = new ArrayList<>();
        for (String word : dict) {
            if(word.length() != pattern.length())
                continue;
            HashMap<Character, Character> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            boolean notMatched = false;
            for (int i = 0; i < pattern.length(); i++) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);


                if (map.containsKey(w)) {
                    if (map.get(w) != p) {
                        notMatched = true;
                        break;
                    }
                }else {
                    if(set.contains(p)){
                        notMatched = true;
                        break;
                    }
                    map.put(w,p);
                    set.add(p);
                }
            }

            if(!notMatched)
                res.add(word);


        }
        return res;
    }
    public static void main(String[] args) {

        ArrayList<String> dict = new ArrayList<String>();
        dict.add("abb");
        dict.add("abc");
        dict.add("xyz");
        dict.add("xyy");
        String pattern = "foo";
        System.out.println(findMatchedWords(dict, pattern));
    }
}
