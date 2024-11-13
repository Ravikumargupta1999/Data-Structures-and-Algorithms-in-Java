// https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1

public class Bit_Manipulation_475 {
    public static int countSetBits(int n){
        if(n == 0)
            return 0;
        int x = largestPowerof2inRange(n);

        int btill2x = x*(1<<(x-1));
        int msb2ton = n - (1<<x) +1;
        int rest = n - ( 1<<x);
        return btill2x + msb2ton + countSetBits(rest);

    }
    public static int largestPowerof2inRange(int n)
    {
        int x =0;
        while ((1 << x) <= n)
            x++;
        return x-1;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(10000007));
    }
}
