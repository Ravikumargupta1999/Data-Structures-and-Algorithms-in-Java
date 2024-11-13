import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Rank_The_Permutation {
    List<String> list = new ArrayList<>();
    public long findRank(String str) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++)
            set.add(str.charAt(i));
        if(str.length() != set.size())
            return 0;
        printPermutation(str,"");
        Collections.sort(list);
        System.out.println(list);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
            if(str.equals(list.get(i))) {
                return i;
            }
        }
        return 0;
    }
    public  void printPermutation(String str,String asf)
    {
        if(str.length() == 0)
        {
            list.add(asf);
            return;
        }
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            String qlpart = str.substring(0,i);
            String qrpart = str.substring(i+1);
            String rop = qlpart + qrpart;
            printPermutation(rop,asf+ch);
        }
    }

    public static void main(String[] args) {
        Rank_The_Permutation a = new Rank_The_Permutation();
        System.out.println(a.findRank("qwertyuiopasdfghjk"));
    }
}
