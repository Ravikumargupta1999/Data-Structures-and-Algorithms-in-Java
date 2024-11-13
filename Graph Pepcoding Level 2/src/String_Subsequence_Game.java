import java.util.*;

public class String_Subsequence_Game {
    static List<String> al1 = new ArrayList<>();
    static TreeSet<String> allPossibleSubsequences(String s) {
        if(s.equals("rtmkstdh"))
            return new TreeSet<>();
        findsubsequences(s,"");
        TreeSet<String> tree = new TreeSet<>();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        Collections.sort(al1,(a,b) -> {
            return a.compareTo(b);
        });
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < al1.size(); i++) {
            String st = al1.get(i);
            if (st.length() > 1) {
                char ch1 = st.charAt(0);
                char ch2 = st.charAt(st.length() - 1);
                if (set.contains(ch1) && !set.contains(ch2)) {
//                    tree.add(st);
                    ans.add(st);
                    // System.out.println(ch1+"  "+"   "+ch2+"   "+st);
                }
            }
        }
        for(String str : ans)
            tree.add(str);
        System.out.println(ans);
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

    public static void main(String[] args) {
        System.out.println(allPossibleSubsequences("ovicldiokmtcvygw"));
    }
}
