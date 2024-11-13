public class Generate_all_Palindromic_Numbers_Less_Than_N {
    static int palindromicNumbers(int N) {
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (isPalindrome(i))
                count++;
        }
        return count;
    }

    static boolean isPalindrome(int n) {
        String str = Integer.toString(n);

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
}
