import java.lang.reflect.Array;
import java.util.ArrayList;

public class FactorsOfNumber {
    public static void main(String[] args) {
        System.out.println(factor1(36));
        System.out.println(factor2(36));
        System.out.println("");
        factor3(56);
    }
    // O(n)
    public static int factor1(int n)
    {
        int count = 0;
        for(int i=1;i<=n;i++)
        {
            if(n%i == 0)
                count++;
        }
        return count;
    }
    // O(sqrt(n))
    public static int factor2(int n)
    {
        int count = 0;
        for(int i=1;i<=Math.sqrt(n);i++)
        {
            if(n % i == 0)
            {
                if(n/i == i)
                    count+=1;
                else
                    count+=2;
            }
        }
        return count;
    }
    public static void factor3(int n)
    {
        int count = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++)
        {
            if(n % i == 0)
            {
                if(n/i == i) {
                    System.out.print(i+"  ");
                }
                else {
                    System.out.print(i+"  ");
                    al.add(n/i);
                }
            }
        }
        for(int i= al.size()-1;i>=0;i--)
            System.out.print(al.get(i)+"  ");
        System.out.println("");

    }
}
