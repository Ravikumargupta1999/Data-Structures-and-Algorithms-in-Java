package Pattern_Level_1;

import java.util.Scanner;

public class Pattern_12 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.print(0 + "\t");
        if (n < 2)
            return;
        System.out.println("");
        System.out.print(1 + "\t" + 1 + "\t");
        System.out.println("");


        int num1 = 1;
        int num2 = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == 1 && j == 1)
                    System.out.print(0 + "\t");
                else
                    System.out.print((num1 + num2) + "\t");
                int temp = num2;
                num2 = num2 + num1;
                num1 = temp;
            }
            System.out.println("");
        }

    }
}
