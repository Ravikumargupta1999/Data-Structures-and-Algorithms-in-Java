import java.util.Arrays;

public class String_Palindrome {
    public static boolean isPalindrome(String str)
    {
        int i=0;
        int j = str.length()-1;
        while (i <= j)
        {
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static boolean checkPalindrome(String str)
    {
        for(int i=0;i<= str.length()/2;i++)
        {
//            System.out.println(i + "  "+(str.length()-1-i));
            if(str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
//        System.out.println(Arrays.toString(str.split(" ",",",":")));
        System.out.println(isPalindrome("RisdrsiRy"));
        System.out.println(checkPalindrome("RyisdrsiyR"));
    }
}
