import java.util.HashMap;
import java.util.Scanner;

public class ExtractTheNumberFromTheString {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String str = s.nextLine();
         ExtractNumber(str);
       // System.out.println(value);
    }
    public static void ExtractNumber(String str) {
        str = str.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");
        str = str + " ";


       //// if (str.equals(""))
       //     return "-1";
        // 5057 97
        String temp = "0";

        // holds sum of all numbers present in the string
        int num = 0;

        // read each character in input string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch))
                temp += ch;
            else {
                num += Integer.parseInt(temp);
                System.out.println(num);
                temp = "0";
            }
            if(ch == ' ')
            {
               // if(num.)
                num =0;
            }

        }
        System.out.println(num);
      }

}

// This i ravi kumar 5067 and 97 gooodbye