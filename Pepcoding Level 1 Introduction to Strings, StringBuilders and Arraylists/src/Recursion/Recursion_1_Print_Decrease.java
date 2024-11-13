package Recursion;

public class Recursion_1_Print_Decrease {
    public static void main(String[] args) {
        printNumber(5);
    }
    public static void printNumber(int n)
    {
        if( n == 1) {
            System.out.print(n+"\n");
            return;
        }
        System.out.print(n+"  ");
        printNumber(n-1);

    }
}
