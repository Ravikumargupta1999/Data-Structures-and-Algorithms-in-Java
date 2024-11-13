package Biweekly_Contest_71;

public class Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits {
    public int minimumSum(int num) {
        String s = Integer.toString(num);
        char[] arr = new char[10];
        for (char c : s.toCharArray())
            arr[c - '0']++;
        s = "";
        for (int i = 0; i < 10; i++) {
            while (arr[i]-- > 0) {
                s = s + "" + i;
            }
        }
        String s1 = s.charAt(0) + "" + s.charAt(3);
        String s2 = s.charAt(1) + "" + s.charAt(2);
        return Integer.parseInt(s1) + Integer.parseInt(s2);
    }
}
