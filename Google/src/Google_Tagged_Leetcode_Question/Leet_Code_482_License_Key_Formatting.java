package Google_Tagged_Leetcode_Question;

public class Leet_Code_482_License_Key_Formatting {
    public static void main(String[] args) {
//        s = "5F3Z-2e-9-w", k = 4

        String s = "5F3Z-2e-9-w";
        int k = 4;
        System.out.println(licenseKeyFormatting(s,k));
    }

    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '-')
                continue;
            else if (Character.isAlphabetic(ch))
                sb.append(Character.toUpperCase(ch));
            else
                sb.append(ch);
        }

        StringBuilder res = new StringBuilder();
        int i = sb.length() - 1;
        while (true) {

            int temp = k;
            while (temp-- > 0 && i >= 0) {
                res.append(sb.charAt(i));
                i--;
            }
            if (i < 0)
                break;
            res.append('-');
        }
        return res.reverse().toString();
    }
}
//:s="2-5g-3-J",k=2
//        Output:"2-5G-3J"
//
//        25g3J
//        J3-g5-2
//        2-5g-3J