public class Bit_Manipulation_476 {
    public static boolean isPowerofTwo(long n){
        if(n == 0)
            return false;
        long val = ( n & (n-1));
        if(val == 0)
            return true;
        else
            return false;

    }
}
