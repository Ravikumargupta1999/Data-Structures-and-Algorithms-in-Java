public class String_90_Minimum_characters_to_be_added_at_front_to_make_string_palindrome_Brute_Force {
    // TLE
    public static int min_Character(String str) {
        StringBuilder sb = new StringBuilder(str);
        int count = 0;
        int flag = 0;
        while (sb.length() > 0) {
            if (isPalindrome(sb)) {
                flag = 1;
                break;
            } else {
                count++;
                sb = new StringBuilder(sb.substring(0, sb.length() - 1));
            }
        }
        if (flag == 1)
            return count;
        return 0;
    }

    public static boolean isPalindrome(StringBuilder str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

//     https://www.codingninjas.com/codestudio/problems/minimum-characters-for-palindrome_893000?leftPanelTab=1
    public static int minAddition(String str) {
        char[] arr = str.toCharArray();
        int j = str.length() - 1;
        int count = 0;
        while (j >= 0) {
            if (isPalindromic(arr, 0, j))
                return count;
            count++;
            j--;
        }
        return count;
    }

    public static boolean isPalindromic(char[] arr, int l, int r) {
        while (l < r) {
            if (arr[l] != arr[r])
                return false;
            l++;
            r--;
        }
        return true;
    }

}
