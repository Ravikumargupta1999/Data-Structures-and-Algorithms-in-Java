
// Done

public class String_62_Count_And_Say {
    // https://leetcode.com/problems/count-and-say/
    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        String str = "11";
        for (int i = 3; i <= n; i++) {
            String temp = "";
            int count = 1;
            char prev = str.charAt(0);
            for (int j = 1; j < str.length(); j++) {
                char curr = str.charAt(j);
                if (curr == prev) {
                    count++;
                } else {
                    temp += (count + "" + prev);
                    prev = curr;
                    count = 1;
                }
            }
            temp += (count + "" + prev);
            str = temp;
        }
        return str;

    }
    // https://practice.geeksforgeeks.org/problems/decode-the-pattern1138/1#
    public static String CountAndSay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        String s = "11";
        for (int i = 3; i <= n; i++) {
            String t = "";
            s = s + "$";
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    t = t + count;
                    t = t + s.charAt(j - 1);
                    count = 1;
                } else
                    count++;
            }
            s = t;
        }
        return s;
    }
}
