import java.util.Scanner;

public class Largest {
    public static int largestNum(int a,int b,int c)
    {
        int max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;
        return max;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        System.out.println(largestNum(a,b,c));
    }
}
