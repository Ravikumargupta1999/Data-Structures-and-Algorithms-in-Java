package Pattern_Level_1;

import java.util.Scanner;

public class Pattern_15_Temp_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = n / 2;
        int st = 1;
        for (int i = 1; i <= n; i++) {
            printSpace(sp);
            printStar(st);
            System.out.println("");
            if (i <= n / 2) {
                sp--;
                st += 2;
            } else {
                sp++;
                st -= 2;
            }
        }
    }

    public static void printSpace(int total) {
        for (int i = 1; i <= total; i++) {
            System.out.print("\t");
        }

    }

    public static void printStar(int total) {
        for (int i = 1; i <= total; i++) {
            System.out.print("*\t");
        }

    }
}
