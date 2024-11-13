package Time_And_Space_Complexity;

import java.util.Scanner;

public class Sort_Dates {
    public static void sortDates(String[] arr) {
        countSort(arr, 1000000, 100, 32);
        countSort(arr, 10000, 100, 13);
        countSort(arr, 1, 10000, 2501);
    }

    public static void countSort(String[] arr, int div, int mod, int range) {
        int[] frq = new int[range];
        for (int i = 0; i < arr.length; i++) {
            frq[Integer.parseInt(arr[i], 10) / div % mod]++;
        }
        for (int i = 1; i < frq.length; i++) {
            frq[i] = frq[i] + frq[i - 1];
        }

        String[] ans = new String[arr.length];
        for (int i = ans.length - 1; i >= 0; i--) {
            int pos = frq[Integer.parseInt(arr[i], 10) / div % mod] - 1;
            ans[pos] = arr[i];
            frq[Integer.parseInt(arr[i], 10) / div % mod]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }
}
//5
//        12041996
//        20101996
//        05061997
//        12041989
//        11081987