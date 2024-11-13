package Time_And_Space_Complexity;

import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/largest-even-number3821/1#
// based on counting sort
public class Largest_Even_Number {
    public static void main(String[] args) {
        String str = "3555";
        System.out.println(LargestEven(str));
    }

    public static String LargestEven(String S) {

        int[] freq = new int[10];
        for (char ch : S.toCharArray()) {
            freq[(int) (ch - '0')]++;
        }
        boolean even = false;
        for (int i = 0; i < freq.length; i++) {
            if (i % 2 == 0 && freq[i] > 0) {
                even = true;
                break;
            }
        }
        String ch = "";
        if (even) {
            for (int i = 0; i < freq.length; i++) {
                if (i % 2 == 0 && freq[i] > 0) {
                    ch = Integer.toString(i);
                    freq[i]--;
                    break;
                }
            }
        } else {
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 0) {
                    ch = Integer.toString(i);
                    freq[i]--;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = freq.length - 1; i >= 0; i--) {
            for(int j = 0 ; j<freq[i];j++)
            {
                sb.append(i);
            }
        }
        sb.append(ch);

        return sb.toString();
    }
}
