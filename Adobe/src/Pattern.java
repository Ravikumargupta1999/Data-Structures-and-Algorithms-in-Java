public class Pattern {
    public static void printPattern(int n)
    {
        int size = 2*n - 1;
        int[][] arr = new int[size][size];
       // for(int)
        for(int i=1;i<=n+2;i++)
        {
            for(int j = 1 ; j <= n+2 ;j++)
            {
                if(i == 1|| i == n + 2 || j == 1 || j == n+2)
                {
                   System.out.print(n+" ");
                }
                else if (i == 2|| i == n + 1 || j == 2 || j == n+1)
                {
                    System.out.print((n-1)+" ");
                }
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        printPattern(3);

    }
}
