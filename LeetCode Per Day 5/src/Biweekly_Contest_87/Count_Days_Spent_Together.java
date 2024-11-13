package Biweekly_Contest_87;

import java.util.HashMap;
//"09-01"
//        "10-19"
//        "06-19"
////        "10-20"
public class Count_Days_Spent_Together {
    public static void main(String[] args) {
        String arriveAlice = "09-01", leaveAlice = "10-19", arriveBob = "06-19", leaveBob = "10-20";
        System.out.println(countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a1 = Integer.parseInt(arriveAlice.substring(0, 2));
        int a2 = Integer.parseInt(leaveAlice.substring(0, 2));
        int b1 = Integer.parseInt(arriveBob.substring(0, 2));
        int b2 = Integer.parseInt(leaveBob.substring(0, 2));
//        System.out.println(a1 + "  " + a2 + "  " + b1 + "  " + b2);

        if (b2 < a1)
            return 0;
        if (b1 > a2)
            return 0;

        int d1 = Integer.parseInt(arriveAlice.substring(3));
        int d2 = Integer.parseInt(leaveAlice.substring(3));
        int d3 = Integer.parseInt(arriveBob.substring(3));
        int d4 = Integer.parseInt(leaveBob.substring(3));
//        System.out.println(d1 + "  " + d2 + "   " + d3 + "   " + d4);

        boolean[][] arr1 = new boolean[13][32];
        boolean[][] arr2 = new boolean[13][32];

        fun(a1, a2, d1, d2, arr1);
        fun(b1, b2, d3, d4, arr2);
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] && arr2[i][j])
                    count++;
            }
        }
        return count;
    }

    public static void fun(int a1, int a2, int d1, int d2, boolean[][] arr) {
        int[] temp = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println(a1 + "  " + a2 + "   " + d1 + "   " + d2);
        int count = 0;
        if (a1 == a2) {
            for (int i = d1; i <= d2; i++) {
                arr[a1][i] = true;
                count++;
            }
        } else {
            for (int i = d1; i <= temp[a1]; i++) {
                arr[a1][i] = true;
                count++;
            }
            for (int i = a1 + 1; i < a2; i++) {
                if (i >= a2)
                    break;
                for (int j = 1; j <= temp[i]; j++) {
                    arr[i][j] = true;
                    count++;
                }
            }
            for (int i = 1; i <= d2; i++) {
                arr[a2][i] = true;
                count++;
            }
        }
    }
}
