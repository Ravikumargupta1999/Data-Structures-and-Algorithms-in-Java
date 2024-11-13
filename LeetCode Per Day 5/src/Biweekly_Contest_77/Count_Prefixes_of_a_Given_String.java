package Biweekly_Contest_77;

import java.util.HashSet;

public class Count_Prefixes_of_a_Given_String {
    public int countPrefixes(String[] words, String s) {
        HashSet<String> set = new HashSet<>();
        for (int i=0;i<s.length();i++){
            set.add(s.substring(0,i+1));
        }
        int count = 0;
        for (String word : words){
            if(set.contains(word))
                count++;
        }
        return count;
    }

}
