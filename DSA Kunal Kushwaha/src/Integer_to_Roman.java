import java.util.HashMap;

public class Integer_to_Roman {
    public static void main(String[] args) {
        System.out.println(intToRoman(3993));
    }
    //https://leetcode.com/problems/integer-to-roman/submissions/

    public static String intToRoman(int num) {
        int[] incode = {1000, 900,500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strCode = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
//        System.out.println(incode.length);
//        System.out.println(strCode.length);
        for (int i = 0; i < incode.length; i++) {
            while (num >= incode[i]) {
                num -= incode[i];
                sb.append(strCode[i]);
            }
        }
        return sb.toString();

    }
}
