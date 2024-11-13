package Day2;

import java.util.Scanner;

public class Diagonal_Difference {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = S.nextInt();
            }
        }


        int leftdiagonal = 0;
        int rightdiagonal = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == j) {
                    leftdiagonal = leftdiagonal + a[i][j];
                }
                if (i + j == a.length - 1) {
                    rightdiagonal = rightdiagonal + a[i][j];
                }

            }
        }


        System.out.println(Math.abs(leftdiagonal - rightdiagonal));
    }
}
