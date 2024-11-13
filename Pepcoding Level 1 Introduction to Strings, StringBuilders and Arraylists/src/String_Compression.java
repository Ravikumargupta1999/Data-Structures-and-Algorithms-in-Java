public class String_Compression {
    public static void main(String[] args) {
        String str = "abbbbbb";
        String str1 = compression1(str);
        System.out.println(str1 + "   " + str1.length());

        String str2 = compression2(str);
        System.out.println("\n\n" + str2 + "   " + str2.length());
    }

    // https://leetcode.com/problems/string-compression/submissions/6
    public int compress(char[] str) {
        String s = str[0] + "";
        int count = 1;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == str[i - 1])
                count++;
            else {
                if (count > 1) {
                    s += count;
                    count = 1;
                }
                s += str[i];
            }
        }
        if (count > 1)
            s += count;
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.charAt(i);
        }
        return s.length();
    }

    static String compression1(String str) {
        String s = str.charAt(0) + "";
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                s += str.charAt(i);
            }
        }
        return s;
    }

    static String compression2(String str) {
        String s = str.charAt(0) + "";
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) count++;
            else {
                if (count > 1) {
                    s += count;
                    count = 1;
                }
                s += str.charAt(i);
            }
        }
        if (count > 1)
            s += count;
        return s;
    }
}
