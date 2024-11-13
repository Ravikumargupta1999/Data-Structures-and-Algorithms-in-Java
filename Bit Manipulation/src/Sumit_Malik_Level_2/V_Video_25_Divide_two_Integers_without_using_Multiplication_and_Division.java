package Sumit_Malik_Level_2;

import java.util.Scanner;

public class V_Video_25_Divide_two_Integers_without_using_Multiplication_and_Division {
    // https://www.youtube.com/watch?v=k9Yxy-NhSTA&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=25
    // https://www.geeksforgeeks.org/calculate-7n8-without-using-division-and-multiplication-operators/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int val = (((n << 3) - n) >> 3);
        System.out.println(val);
    }
}
