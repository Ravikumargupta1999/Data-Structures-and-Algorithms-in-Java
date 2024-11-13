public class String_82_Longest_Common_Prefix {
    // https://leetcode.com/problems/longest-common-prefix/
    // https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1/
    // https://www.youtube.com/watch?v=bl8ue-dTxgs

    public String longestCommonPrefix(String[] arr) {
        int n = arr.length;
        if (n == 0)
            return "";
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (prefix.length() == 0) {
                return "";
            }
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    String longestCommonPrefix(String arr[], int n) {
        String prefix = arr[0];
        for (int i = 1; i < n; i++) {

            int j = 0;
            for (; j < Math.min(arr[i].length(), prefix.length()); j++) {
                if (arr[i].charAt(j) != prefix.charAt(j))
                    break;
            }
            prefix = arr[i].substring(0, j);
        }
        if (prefix.length() == 0)
            return "-1";
        return prefix;
    }
}
