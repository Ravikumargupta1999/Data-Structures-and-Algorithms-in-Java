package Biweekly_Contest_97;

import java.util.Arrays;

public class Problem_3 {
    public static void main(String[] args) {
        int[] main = {1, 1, 2, 2, 3, 3, 5};
        System.out.println(maximizeWin(main, 2));
    }

    public static int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] arr = new int[prizePositions[n - 1] + 1];

        for (int prize : prizePositions) {
            arr[prize]++;
        }

        int[] prefix = new int[prizePositions[n - 1] + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(prefix));


        int[] sum = new int[prizePositions[n - 1] + 1];
        for (int i = k + 1; i < prefix.length; i++) {
            System.out.println(i + "   " + (i - (k + 1)));
            sum[i] = prefix[i] - prefix[i - (k + 1)];
        }
        System.out.println(Arrays.toString(sum));
        return 55;
    }
}
