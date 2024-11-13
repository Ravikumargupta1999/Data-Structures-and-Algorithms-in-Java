import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

///https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string-1587115620/1/?difficulty[]=0&page=1&company[]=Amazon&category[]=Recursion&query=difficulty[]0page1company[]Amazoncategory[]Recursion
public class String_Permutations {
    ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> permutation(String str)
    {

        printPermutation(str,"");
        Collections.sort(list);
        return list;
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
}
