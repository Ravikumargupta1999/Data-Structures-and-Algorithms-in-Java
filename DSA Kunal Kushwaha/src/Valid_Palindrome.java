import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Valid_Palindrome {
    public boolean checkPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1)
            return true;
        if (str.length() == 2)
            return str.charAt(0) == str.charAt(1);
        for (int i = 0; i <= str.length() / 2; i++) {
//            System.out.println(i + "  "+(str.length()-1-i));
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))

                return false;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return true;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
                str.append((s.charAt(i)));
            else if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))
                str.append((s.charAt(i)));

            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                str.append((s.charAt(i)));
        }
        return checkPalindrome(str.toString().toLowerCase());

    }

    public static void main(String[] args) {
        Valid_Palindrome a = new Valid_Palindrome();
        System.out.println(a.isPalindrome("0P"));
    }
}
