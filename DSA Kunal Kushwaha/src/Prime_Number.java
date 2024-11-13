import java.util.Scanner;

public class Prime_Number {
    public static int checkPrime(int N)
    {
        if(N <= 1)
        {
            return 0;
        }
        int C = 2;
        while (C*C <= N)
        {
            if(N%C == 0)
                return 0;
            C += 1;
        }
        return 1;

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int value = checkPrime(n);
        System.out.println(value);
    }
}
