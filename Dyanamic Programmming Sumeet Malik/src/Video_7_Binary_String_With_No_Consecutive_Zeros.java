public class Video_7_Binary_String_With_No_Consecutive_Zeros {
    static int function(int n)
    {
        int[] dp0 = new int[n+1];
        int[] dp1 = new int[n+1];
        dp0[1] = 1;
        dp1[1] = 1;
        for(int i=2;i<=n;i++)
        {
            dp0[i] = dp1[i-1];
            dp1[i] = dp1[i-1]+dp0[i-1];
            System.out.println(i+"   "+(dp0[i] + dp1[i]));
        }
        return dp0[n]+dp1[n];
    }
    // without extra space
    static int function1(int n)
    {

        int oczeros = 1;
        int ocones = 1;
        for(int i=2;i<=n;i++)
        {

            int nczeros = ocones;
            int ncones  = ocones + oczeros;
            ocones = ncones;
            oczeros = nczeros;
        }
        return ocones + oczeros;
    }
    public static void main(String[] args) {
        System.out.println(function(43));
    }
}
