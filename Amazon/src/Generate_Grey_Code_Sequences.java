import java.util.ArrayList;
import java.util.Collections;
//https://practice.geeksforgeeks.org/problems/generate-grey-code-sequences/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0company[]Amazonpage5

public class Generate_Grey_Code_Sequences {
    static ArrayList<String> generateCode(int n)
    {
        if( n == 1)
        {
            ArrayList<String> al = new ArrayList<>();
            al.add("0");
            al.add("1");
            return al;
        }
        ArrayList<String> al = generateCode(n-1);
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<al.size();i++)
        {

            result.add( "0" + al.get(i));


        }
        for(int i=al.size()-1;i>=0;i--)
        {
            result.add("1" + al.get(i));

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateCode(3));
        String str1 = "000 001 011 010 110 111 101 100 ";
        String str2 = "011 010 001 000 111 110 101 100 ";
        System.out.println(str1.compareTo(str2));
    }
}
