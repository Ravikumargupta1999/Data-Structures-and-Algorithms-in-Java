public class Any_Base_To_Any_Base {
    public static void main(String[] args) {
        System.out.println(anyBaseToAnyBase(10011,2,8));
    }
    static  int anyBaseToAnyBase(int n,int b1,int b2)
    {
        int dec = anyBaseToDecimal(n,b1);
        System.out.println(dec);
        return decimalToAnyBase(dec,b2);
    }
    static int anyBaseToDecimal(int n,int b)
    {
        int ans = 0;
        int p = 1;
        while (n > 0)
        {
            int temp = n % 10;
            n = n/10;
            ans = ans + (temp * p);
            p = p * b;
        }
        return ans;
    }
    static int decimalToAnyBase(int n, int b) {
        int ans = 0;
        int p = 1;
        while (n > 0) {
            int temp = n % b;
            n = n / b;
            ans += (temp * p);
            p = p * 10;
        }
        return ans;
    }

}
