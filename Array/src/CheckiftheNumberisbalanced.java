import java.util.Scanner;

public class CheckiftheNumberisbalanced {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Boolean b = balancedNumber(str);
        System.out.println(b);
    }
    public static Boolean balancedNumber(String s)
    {
        int len = s.length();
        int i = 0;
        int j = s.length()-1;
        len = len/2;
        int sum1=0;
        int sum2=0;
        if(s.length()%2 == 0) {
            for (i = 0; i < len; i++)
                sum1 += s.charAt(i);
            for (j = s.length() - 1; j >= len; j--)
                sum2 += s.charAt(j);
            if (sum1 == sum2)
                return true;
            else
                return false;
        }
        else {
            for (i = 0; i < len; i++)
                sum1 += s.charAt(i);
            for (j = s.length() - 1; j > len; j--)
                sum2 += s.charAt(j);
            if (sum1 == sum2)
                return true;
            else
                return false;
        }


    }
}
