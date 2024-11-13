import java.util.Scanner;

public class BreakANumber {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
       int value =waysToBreakNumber(n);
       System.out.println(value);
    }
    public static int waysToBreakNumber(int n){
        int count = 0;
        count = (n + 1) * (n + 2) / 2;
        return count;
    }
}
