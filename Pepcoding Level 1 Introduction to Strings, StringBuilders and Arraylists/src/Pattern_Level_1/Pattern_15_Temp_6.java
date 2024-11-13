package Pattern_Level_1;

import java.util.Scanner;

public class Pattern_15_Temp_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = n / 2;
        int st = 1;
        int val  = 1;
        for (int i = 1; i <= n; i++) {
            printSpace(sp);
            printStar(st,val);
            System.out.println("");
            if (i <= n / 2) {
                sp--;
                st += 2;
                val++;
            } else {
                sp++;
                st -= 2;
                val--;
            }

        }
    }

    public static void printSpace(int total) {
        for (int i = 1; i <= total; i++) {
            System.out.print("\t");
        }

    }

    public static void printStar(int total,int val) {
        for (int i = 1; i <= total; i++) {
            System.out.print(val+"\t");
            if(i <= total/2)
                val++;
            else
                val--;
        }

    }
}