package Pattern_Level_1;

import java.util.Scanner;

public class Pattern_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            if(i<= n/2)
            {
                printSpace(n/2);
                printStar(i);
            }
            else if( i == n/2+1)
            {
                printStar(n);
            }
            else
            {
                printSpace(n/2);
                printStar(n-i+1);
            }
            System.out.println("");
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
