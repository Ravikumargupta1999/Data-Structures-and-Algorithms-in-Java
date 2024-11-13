import java.util.ArrayList;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverseLastKCharacter("rishika",8));
//        ArrayList<Character> list = new ArrayList<>();
//        list.add('3');
//        list.add('2');
//        list.set(1, '1');
//
//        String sss = "rishika";
//        Scanner svn = new Scanner(System.in);
//        String temp = svn.nextLine();
//        StringBuilder sb = new StringBuilder(temp);
//        sb.setCharAt(4,'g');
//        System.out.println(sb);

//
//        String str = "rishikaRAVI";
//
//        // using for loop print all character
//        for (int i = 0; i <= str.length() - 1; i++) {
//            System.out.print(str.charAt(i) + "\t");
//        }
//        System.out.println("\n");

        // print only if it is vowel
//        for (int i = 0; i <= str.length() - 1; i++) {
//            char ch = str.charAt(i);
//            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
//                System.out.print(str.charAt(i) + "\t");
//            }
//
//        }
//        System.out.println("\n");

        // Reverse a string
//        String res = "";
//        int n = str.length();
//        for (int i = n - 1; i >= 0; i--) {
//            res = res + str.charAt(i);
//        }
//        System.out.println(res + "\n\n");


//// write a program to print the count of a character in a given string
//        char ch = 'i';
//        int count = 0;
//        for (int i = 0; i <= str.length() - 1; i++) {
//            if (str.charAt(i) == ch)
//                count += 1;
//        }
//        System.out.println(ch + "\t" + count);
//        System.out.println("\n\n");


//        // "i love rishika"

//        StringBuilder sb = new StringBuilder("ravi love rishika a lot");
//        if (sb.length() > 0)
//            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
//        for (int i = 0; i <= sb.length() - 1; i++) {
//            if (sb.charAt(i) == ' ' && i != sb.length() - 1) {
//                // get (i+1)th character
//                char temp = sb.charAt(i + 1);
//
//                // Convert (i+1)th i.e. temp to Uppercase
//                temp = Character.toUpperCase(temp);
//
//                // set (i+1)th character as new upper case character
//                sb.setCharAt(i + 1, temp);
//            }
//        }
//        System.out.println(sb);
//
//
//        // Reverse last two Character in String

//        StringBuilder sb1 = new StringBuilder("Rishika");
//        if (sb1.length() > 1) {
//            n = sb1.length();
//            char last = sb1.charAt(n - 1);
//            char secondLast = sb1.charAt(n - 2);
//            sb1.setCharAt(n - 1, secondLast);
//            sb1.setCharAt(n - 2, last);
//            System.out.println(sb1);
//        }

    }

    public static String reverseLastKCharacter(String str, int k) {
        int n = str.length();

        String res = "";

        for (int i = 0; i <= n - k - 1; i++) {
            res = res + str.charAt(i);
        }

        for (int i = n - 1; i >= n - k; i--) {
            res = res + str.charAt(i);
        }
        return res;
    }
}
