import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Erp_Password {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();

            if(check(S))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
    public static boolean check(String str)
    {

        if(str.length()<10)
            return false;
        int upper = 0, lower = 0, number = 0, special = 0;
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                upper++;
            else if (ch >= 'a' && ch <= 'z')
                lower++;
            else if (ch >= '0' && ch <= '9')
                number++;
            else
                special++;
        }
        if(upper == 0 || lower == 0 || number  == 0 || special == 0)
            return false;
        if(str.charAt(0) < 'a' ||  str.charAt(0) > 'z')
            return false;
        if(str.charAt(0) < 'a' ||  str.charAt(str.length()-1) > 'z')
            return false;

        return true;

    }
}
