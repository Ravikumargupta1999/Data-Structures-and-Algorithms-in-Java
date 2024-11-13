package Recursion;

public class Recursion_1_Print_Increase {
    public static void main(String[] args) {
        printNumbers(5);
        System.out.print("\n");
    }
    public static void printNumbers(int n)
    {
        if( n == 1)
        {
            System.out.print(n + " ");
            return;
        }
        printNumbers(n-1);
        System.out.print(n+" ");
    }
}
