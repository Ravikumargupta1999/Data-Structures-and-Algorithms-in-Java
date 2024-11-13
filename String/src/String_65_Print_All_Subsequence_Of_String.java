

// Done

public class String_65_Print_All_Subsequence_Of_String {

    public static void main(String[] args) {
        String str = "abc";
        printSubsequence(str, "");

        printSubsequence1(0, str, "");

    }

    public static void printSubsequence(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + "  ");
            return;
        }
        char ch = str.charAt(0);
        String temp = str.substring(1);
        printSubsequence(temp, ans + ch);
        printSubsequence(temp, ans + "");
    }

    public static void printSubsequence1(int index, String str, String ans) {
        if (index == str.length()) {
            System.out.print(ans + "  ");
            return;
        }
        char ch = str.charAt(index);
        printSubsequence1(index + 1, str, ans + ch);
        printSubsequence1(index + 1, str, ans);
    }
}
