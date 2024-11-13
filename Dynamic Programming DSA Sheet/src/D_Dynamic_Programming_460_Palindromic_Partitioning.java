import java.util.ArrayList;
import java.util.List;

public class D_Dynamic_Programming_460_Palindromic_Partitioning {
    // https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1#
    // https://www.youtube.com/watch?v=qmTtAbOTqcg
    // TC : O(n^3)
    // SC : O(n^2)
    static int palindromicPartition1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp[0].length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    char ch1 = s.charAt(i);
                    char ch2 = s.charAt(j);

                    dp[i][j] = ch1 == ch2 ? true : false;
                } else {
                    char ch1 = s.charAt(i);
                    char ch2 = s.charAt(j);

                    dp[i][j] = ch1 == ch2 ? dp[i + 1][j - 1] : false;
                }
            }
        }


        int[][] strg = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    strg[i][j] = 0;
                } else if (g == 1) {
                    char ch1 = s.charAt(i);
                    char ch2 = s.charAt(j);

                    strg[i][j] = ch1 == ch2 ? 0 : 1;
                } else {
                    if (dp[i][j]) {
                        strg[i][j] = 0;
                        continue;
                    }
                    int min = n + 1;

                    for (int k = i; k < j; k++) {
                        int left = strg[i][k];
                        int right = strg[k + 1][j];

                        min = Math.min(min, left + right + 1);
                    }
                    strg[i][j] = min;
                }
            }
        }
        return strg[0][n - 1];
    }

    // TC : O(n^2)
    // SC : O(n^2)
    public static int partitioningPalindromic1(String str) {
        int n = str.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int g = 0; g < str.length(); g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    isPalindrome[i][j] = true;
                } else if (g == 1) {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    isPalindrome[i][j] = ch1 == ch2 ? true : false;
                } else {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    isPalindrome[i][j] = ch1 == ch2 && isPalindrome[i + 1][j - 1] ? true : false;
                }
            }
        }


        int[] storage = new int[n];
        storage[0] = 0;

        for (int j = 1; j < n; j++) {

            if (isPalindrome[0][j])
                storage[j] = 0;
            else {
                int min = n + 1;

                for (int i = j; i >= 1; i--) {
                    if (isPalindrome[i][j]) {
                        min = Math.min(min, storage[i - 1]);
                    }
                }
                storage[j] = min + 1;
            }
        }
        return storage[n - 1];

    }

    static int palindromicPartition(String str) {
        List<List<String>> lists = partition(str);
        int min = str.length();

        for (List<String> list : lists)
            min = Math.min(min, list.size());


        return min - 1;
    }

    // https://leetcode.com/problems/palindrome-partitioning/submissions/
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        findSolution(s, temp, list);
        return list;

    }

    static void findSolution(String str, List<String> temp, List<List<String>> list) {
        if (str.length() == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            String right = str.substring(i + 1);
            temp.add(left);
            if (isPalindrome(left)) {
                findSolution(right, temp, list);
            }
            temp.remove(temp.size() - 1);
        }
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

    public static void main(String[] args) {
        System.out.println(palindromicPartition("ababbbabbababa"));
    }
}
