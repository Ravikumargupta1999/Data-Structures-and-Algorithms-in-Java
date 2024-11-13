import java.util.Scanner;

public class Video_47_Maximum_Number_after_K_Swaps {
    static String max;

    public static void findMaximum(String str, int k) {
        if (Double.parseDouble(str) > Double.parseDouble(max)) {
            max = str;
        }
        if (k == 0)
            return;
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                str = swap(str, i, j);
                findMaximum(str, k - 1);
                str = swap(str, i, j);
            }
        }
    }

    static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        return str.substring(0, i) + jth + str.substring(i + 1, j) + ith + str.substring(j + 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        max = str;
        findMaximum(str, k);
        System.out.println(max);
    }
}
