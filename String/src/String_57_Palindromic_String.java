// Done

public class String_57_Palindromic_String {
    // https://practice.geeksforgeeks.org/problems/palindrome-string0817/1
    int isPalindrome1(String S) {
        int i = 0;
        int j = S.length()-1;
        while (i<=j)
        {
            if(S.charAt(i) != S.charAt(j))
                return 0;
            i++;
            j--;

        }
        return 1;
    }
    // https://leetcode.com/problems/valid-palindrome/
    public static boolean isPalindrome(String s) {
       String temp = "";
       for (char ch : s.toCharArray()){
           if(Character.isAlphabetic(ch))
               temp += Character.toLowerCase(ch);
       }
       System.out.println(temp);
       int i=0;
       int j = temp.length()-1;
       while (i < j){
           if(temp.charAt(i) != temp.charAt(j))
               return false;
           i++;
           j--;
       }
       return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}