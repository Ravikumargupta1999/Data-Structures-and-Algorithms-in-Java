public class Valid_Palindrome_II {
    // TLE
//    public boolean validPalindrome(String str) {
//        if(str.length() <= 2)
//            return true;
//        boolean found = false;
//        for(int i=0;i<str.length();i++)
//        {
//            if(isPalindrome(str.substring(0,i)+str.substring(i+1,str.length())))
//            {
//                found = true;
//                break;
//            }
//        }
//        return found;
//    }
//    public boolean isPalindrome(String str) {
//        System.out.println(str);
//        int i=0;
//        int j = str.length()-1;
//        while (i <= j)
//        {
//            if(str.charAt(i) != str.charAt(j))
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        Valid_Palindrome_II v = new Valid_Palindrome_II();
//        System.out.println(v.validPalindrome("abc"));
    }
}
