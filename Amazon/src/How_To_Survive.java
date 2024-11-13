import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s= new Scanner(System.in);
        int t = s.nextInt();
        while ( t-- >0)
        {
            int n = s.nextInt();
            int k = s.nextInt();
            int f = s.nextInt();
            Pair[]  arr = new Pair[n];
            for(int i=0;i<n;i++)
            {
                int st = s.nextInt();
                int end = s.nextInt();
                Pair temp = new Pair();
                temp.start = st;
                temp.end = end;
                arr[i] = temp;
            }
            int difference = 0;
            for(int i=0;i<n;i++)
            {
                difference += (arr[i].end - arr[i].start);
            }

            if(f-difference < k)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    public static class Pair
    {
        int start ;
        int end ;
    }
}
//3
//        1 10 10
//        0 10
//        2 2 10
//        0 5
//        7 10
//        2 2 12
//        0 5
//        5 10