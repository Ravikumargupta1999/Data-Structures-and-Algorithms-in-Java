public class String_76_Print_First_Letter_Of_Every_Word_In_The_String {
    // https://practice.geeksforgeeks.org/problems/print-first-letter-of-every-word-in-the-string3632/1
    String firstAlphabet(String S) {
        String[] arr = S.split(" ");
        String res = new String("");
        for (String str : arr)
            res += str.charAt(0);
        return res;
    }
}
