package Pattern_Level_1;

import java.util.Scanner;

public class Pattern_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = 2 * n - 3;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }
            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            for (int j = i; j >= 1; j--) {
                if (j != n)
                    System.out.print(j + "\t");
            }
            System.out.println("");
            sp -=2;
        }
    }

}
