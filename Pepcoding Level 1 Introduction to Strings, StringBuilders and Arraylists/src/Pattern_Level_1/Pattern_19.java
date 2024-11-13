package Pattern_Level_1;

import java.util.Scanner;

public class Pattern_19 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                printStar(1,n/2+1);
                printSpace(n/2+2,n-1);
                printStar(n,n);
            } else if (i == n) {
                printStar(1,1);
                printSpace(2,n/2);
                printStar(n/2+1,n);


            } else if (i == n / 2 + 1) {
                printStar(1,n);

            } else if (i > 1 && i <= n / 2) {
                printSpace(1,n/2);
                printStar(n/2+1,n/2+1);
                printSpace(n/2+2,n-1);
                printStar(n,n);
            } else {
                printStar(1,1);
                printSpace(2,n/2);
                printStar(n/2+1,n/2+1);


            }
            System.out.println();
        }

    }

    public static void printSpace(int low,int high) {
        for (int i = low; i <= high; i++) {
            System.out.print("\t");
        }

    }
    public static void printStar(int low,int high) {
        for (int i = low; i <= high; i++) {
            System.out.print("*\t");
        }

    }

}
