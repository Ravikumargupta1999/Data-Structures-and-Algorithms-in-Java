import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/longest-substring-whose-character-rearranged-can-form-a-palindrome/1?page=4&company[]=Amazon&category[]=Dynamic%20Programming&sortBy=submissions

public class Video_7_Longest_Substring_To_Form_A_Palindrom {
    static void generateAllSubString(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                list.add(str.substring(i, j));
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        String str = "adbabd";
        generateAllSubString(str);
        System.out.println(longestSubstring(str));
    }

    // Brute Force
    static int longestSubstring(String str) {
        int n = str.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[26];
            for (int j = i; j < n; j++) {
                arr[str.charAt(j) - 'a']++;
                if(isPalindrome(arr)){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }

    static boolean isPalindrome(int[] arr) {
        int even = 0;
        int odd = 0;
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (val == 0)
                continue;
            if (val % 2 == 0)
                even++;
            else
                odd++;
            total++;
        }
        return even == total || even + 1 == total;
    }
}
