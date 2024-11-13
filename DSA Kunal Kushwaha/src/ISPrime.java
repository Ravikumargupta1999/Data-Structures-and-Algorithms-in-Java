public class ISPrime {
    public static void main(String[] args) {
        System.out.println(checkPrime(68));
    }
    public static boolean checkPrime(int  n)
    {
        int c = 2;
        while (c*c <= n)
        {
            if(n%c == 0)
                return false;
            c++;
        }
        return true;
    }
}
