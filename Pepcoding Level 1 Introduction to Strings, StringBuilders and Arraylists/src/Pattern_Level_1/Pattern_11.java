package Pattern_Level_1;

import java.util.Scanner;

public class Pattern_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + "\t");
                num++;
            }
            System.out.println("");
        }
    }
}
