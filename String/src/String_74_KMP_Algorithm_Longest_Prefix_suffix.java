import java.util.ArrayList;

public class String_74_KMP_Algorithm_Longest_Prefix_suffix {

    // https://practice.geeksforgeeks.org/problems/search-pattern0205/1
    ArrayList<Integer> KMPSearch(String pattern, String text) {
        // your code here
        ArrayList<Integer> list = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();
        int[] lps = ComputerLPSArray(pattern, m);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else {
                    i += 1;
                }
            }
            if (j == m) {
                list.add(i - j);
                j = lps[j - 1];

            }
        }
        if (list.size() == 0)
            list.add(-1);
        return list;

    }

    public static int[] ComputerLPSArray(String str, int m) {
        int[] lps = new int[m];
        int length = 0;
        int i = 1;
        lps[0] = 0;
        while (i < m) {
            if (str.charAt(i) == str.charAt(lps[length])) {
                lps[i] = length + 1;
                length += 1;
                i += 1;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i += 1;
                }
            }
        }
        return lps;
    }

    // https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1
    int lps(String str) {
        int[] lpsTable = new int[str.length()];
        int n = str.length();
        int j = 0;
        int i = j + 1;
        lpsTable[0] = 0;
        while (i < n) {
            if (str.charAt(i) == str.charAt(j)) {
                lpsTable[i] = j + 1;
                j++;
                i++;
            } else {
                if (j > 0) {
                    j = lpsTable[j - 1];
                } else {
                    lpsTable[i] = 0;
                    i++;
                }
            }
        }
        return lpsTable[n - 1];
    }

    // https://leetcode.com/problems/longest-happy-prefix/submissions/
    public String longestPrefix(String str) {
        int[] lpsTable = new int[str.length()];
        int n = str.length();
        int j = 0;
        int i = 1;
        lpsTable[0] = 0;
        while (i < n) {
            if (str.charAt(i) == str.charAt(j)) {
                lpsTable[i] = j + 1;
                j++;
                i++;
            } else {
                if (j > 0) {
                    j = lpsTable[j - 1];
                } else {
                    lpsTable[i] = 0;
                    i++;
                }
            }
        }
        return str.substring(str.length() - lpsTable[n - 1]);
    }
}
