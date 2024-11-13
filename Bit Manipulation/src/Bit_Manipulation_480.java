public class Bit_Manipulation_480 {
    public static void main(String[] args) {
        int n = 45;
//        System.out.println((n >> 1) + "    " + Integer.toBinaryString(n >> 1));
//        System.out.println((n << 1) + "    " + Integer.toBinaryString(n << 1));
//        System.out.println(calculateSquare(n));
        System.out.println(square(15));

    }
    // https://www.youtube.com/watch?v=Rzra9HLoe0Q
    //
    public static int calculateSquare(int n) {
        if (n == 0)
            return 0;

        // Handle negative number
        if (n < 0)
            n = -n;

        // Get floor(n/2) using
        // right shift
        int x = n >> 1;

        // If n is odd;
        if (n % 2 != 0)
            return ((calculateSquare(x) << 2) + (x << 2) + 1);
        else // If n is even
            return (calculateSquare(x) << 2);
    }

    // Approach 2
    // https://www.youtube.com/watch?v=Rzra9HLoe0Q
    public static int square(int num)
    {

        // Handle negative input
        if (num < 0)
            num = -num;

        // Initialize result
        int result = 0, times = num;
//        System.out.println(num+"  "+times+"   "+result);
        while (times > 0)
        {
            int possibleShifts = 0, currTimes = 1;
            while ((currTimes << 1) <= times)
            {
                currTimes = currTimes << 1;
//                System.out.println("currentTimes : "+currTimes);
                ++possibleShifts;
            }
//            System.out.println("Possible Shifts : "+possibleShifts);
//            System.out.println("Nums : "+num);
//            System.out.println("num <<  possibleShifts : "+(num << possibleShifts));
            result = result + (num << possibleShifts);
            times = times - currTimes;
//            System.out.println("Times  "+times+"    currentTimes :  "+currTimes+"\n\n");
        }
        return result;
    }
}
