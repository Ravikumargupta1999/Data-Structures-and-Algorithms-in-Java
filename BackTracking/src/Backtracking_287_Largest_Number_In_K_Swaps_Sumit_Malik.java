import java.util.Scanner;

// not working for larger length
public class Backtracking_287_Largest_Number_In_K_Swaps_Sumit_Malik {
    // https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1#
    // https://www.youtube.com/watch?v=5crucASFoA4&t=562s
    static String max;
    public static String findMaximumNum(String str, int k) {
        max = str;
        findMaximum(str.toCharArray(), k);
        return max;
    }
    public static void findMaximum(char[] str, int k) {
        if (String.valueOf(str).compareTo(max) > 0)
            max = String.valueOf(str);
        if (k == 0)
            return;

        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[j] > str[i]) {
                    swap(str, i, j);
                    findMaximum(str, k - 1);
                    swap(str, i, j);
                }
            }
        }
    }

    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
