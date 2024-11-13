public class Print_all_Palindromic_Substrings {
    public static void main(String[] args) {
        String str = "abccbc";
        printAllPalindrome(str);
    }

    public static void printAllPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (isPalindrome(str.substring(i, j)))
                    System.out.print(str.substring(i, j) + "  ");
            }
        }
        System.out.println("\n");
        return;
    }

    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
