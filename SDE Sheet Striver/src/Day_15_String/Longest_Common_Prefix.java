package Day_15_String;

import javax.swing.text.Style;

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        String[]  strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] arr) {
        int n = arr.length;
        if (n == 0)
            return "";
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (prefix.length() == 0) {
                return "";
            }
            System.out.println("\n");
            while (arr[i].indexOf(prefix) != 0) {
                System.out.println(arr[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println(prefix);
            }
        }

        return prefix;
    }
}
