import java.util.*;

// https://practice.geeksforgeeks.org/problems/string-subsequence-game5515/1/?category[]=Hash&category[]=Hash&difficulty[]=1&page=2&query=category[]Hashdifficulty[]1page2category[]Hash#
// It's right but solution not accepting
public class String_Subsequence_Game {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(allPossibleSubsequences("rtmkstdh"));
    }
    static List<String> al1 = new ArrayList<>();
    static TreeSet<String> allPossibleSubsequences(String s) {
        findsubsequences(s,"");
        TreeSet<String> tree = new TreeSet<>();
        System.out.println(al1);
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = 0; i < al1.size(); i++) {
            String st = al1.get(i);
            if (st.length() > 1) {
                char ch1 = st.charAt(0);
                char ch2 = st.charAt(st.length() - 1);
                if (set.contains(ch1) && !set.contains(ch2)) {
                    tree.add(st);
                    System.out.println(ch1+"  "+"   "+ch2+"   "+st);
                }
            }
        }
        return tree;
    }
    static void findsubsequences(String s, String ans)
    {
        if (s.length() == 0) {
            al1.add(ans);
            return;
        }
        findsubsequences(s.substring(1), ans + s.charAt(0));
        findsubsequences(s.substring(1), ans);
    }



}
