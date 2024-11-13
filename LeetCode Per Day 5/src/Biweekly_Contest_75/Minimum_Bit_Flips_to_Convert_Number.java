package Biweekly_Contest_75;

public class Minimum_Bit_Flips_to_Convert_Number {
    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
    }

    public static int minBitFlips(int start, int goal) {
        String s1 = Integer.toBinaryString(start);
        String s2 = Integer.toBinaryString(goal);
        int len = Math.abs(s1.length() - s2.length());
        if (s1.length() < s2.length()) {
            while (len-- > 0) {
                s1 = "0" + s1;
            }
        } else {
            while (len-- > 0) {
                s2 = "0" + s2;
            }
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;

        }
        return count;
    }
}
