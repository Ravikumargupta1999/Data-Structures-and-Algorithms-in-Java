import java.util.LinkedList;
import java.util.List;

public class String_To_Decimal {
   //
   // public static double LLtoDecimal(LinkedList<Integer> s)
    static double convert(String str)
    {
        int i =0;
        double value = 0;
        int j = str.length()-1;
        while (j>=0)
        {
            if(str.charAt(j) == '0')
            {
                value =value + 0;
                i++;
            }
            else
            {
                value = value + Math.pow(2,i);
                System.out.println(Math.pow(2,i)+"  "+i);
                i++;
            }
            j--;
        }
        return value;
    }
    public static void main(String[] args) {
        System.out.println(convert("1100"));

    }
}
