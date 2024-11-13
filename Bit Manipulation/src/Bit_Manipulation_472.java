public class Bit_Manipulation_472 {

//    static int setBits(int n) {
//        int count = 0;
//        while (n > 0) {
//            n -= (n & -n);
//            count++;
//        }
//        return count;
//
//    }
    static int fun(int n)
    {
        int count =0;
        for(int i=0;i<=n;i++)
        {
            count += setBits(i);
        }
        return count;
    }
    static int setBits(int n) {
        int count = 0;
        while (n > 0) {
            n -= (n & -n);
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(fun(10));
    }
}
