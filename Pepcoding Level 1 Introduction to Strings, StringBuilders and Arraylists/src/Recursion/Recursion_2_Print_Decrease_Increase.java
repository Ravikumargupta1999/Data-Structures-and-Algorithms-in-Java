package Recursion;

public class Recursion_2_Print_Decrease_Increase {
    public static void main(String[] args) {
        printDecreasingIncreasing(7);
        System.out.print("\n");
    }
    public static void printDecreasingIncreasing(int n)
    {
        if( n == 0) {
            System.out.print(n+"  ");

            return;
        }
        System.out.print(n+"  ");
        printDecreasingIncreasing(n-1);
        System.out.print(n+"  ");
    }
}
