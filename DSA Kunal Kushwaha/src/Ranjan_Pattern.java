import javax.sql.rowset.spi.SyncProviderException;
import java.util.Scanner;

public class Ranjan_Pattern {
    public static  void pattern1(int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int space = j;
                int start = n;
                for(int sp = 0;sp<space;sp++)
                {
                    System.out.print(" ");
                }
                for(int st = 0;st<start;st++)
                {
                    System.out.print("*"+"  ");
                }
                System.out.println("");
            }
        }
    }

    public static  void pattern2(int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int space = n-j-1;
                int start = n;
                for(int sp = 0;sp<space;sp++)
                {
                    System.out.print(" ");
                }
                for(int st = 0;st<start;st++)
                {
                    System.out.print("*"+"  ");
                }
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(" Pattern - 1  ");
        pattern1(n);
        System.out.println("\n\n\n");

        System.out.println("   Pattern - 2 ");
        pattern2(n);
    }
}
