package Pattern_Level_1;

import java.util.Scanner;

public class Pattern_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int os = n / 2;
        int is = -1;
        for (int i = 1; i <= n; i++) {
            printSpace(os);
            printStar(1);
            if (i != 1 && i != n) {
                printSpace(is);
                printStar(1);
            }
            System.out.println("");
            if (i <= n / 2) {
                os--;
                is += 2;
            } else {
                os++;
                is -= 2;
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
