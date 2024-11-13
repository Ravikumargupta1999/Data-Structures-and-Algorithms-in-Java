import java.util.HashSet;
import java.util.TreeSet;

public class String_65_String_Subsequence_Game {
    public static void main(String[] args) {
        String str = "aab";
        System.out.println(allPossibleSubsequences(str));
    }
    // https://practice.geeksforgeeks.org/problems/string-subsequence-game5515/1#
    static TreeSet<String> allPossibleSubsequences(String s) {
        HashSet<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        TreeSet<String> set = new TreeSet<>();
        printSubsequence(0,s,"",vowel,set);
        return set;
    }
    public static void printSubsequence(int index,String str,String asf,HashSet<Character> vowel,TreeSet<String> set){
        if(index == str.length()){
            if(asf.length() < 2)
                return;
            char first = asf.charAt(0);
            char last = asf.charAt(asf.length()-1);
            if(vowel.contains(first) && !vowel.contains(last))
                set.add(asf);
            return;
        }
        printSubsequence(index+1,str,asf+str.charAt(index),vowel,set);
        printSubsequence(index+1,str,asf,vowel,set);
    }
}
