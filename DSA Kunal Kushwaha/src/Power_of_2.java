public class Power_of_2 {
    public static boolean isPowerofTwo(long n){

        for(long i=0;i < 132;i++)
        {
            if((1 << i) == n)
                return true;
        }
        return false;


    }

//    // Function to check if given number n is a power of two.
//    public static boolean isPowerofTwo(long n){
//        if(n == 0)
//            return false;
//        long val = ( n & (n-1));
//        if(val == 0)
//            return true;
//        else
//            return false;
//
//    }

    public static void main(String[] args) {
        System.out.println(isPowerofTwo(10995176));
    }
}
