public class Fibonacci_Number_Using_Formula {
    public static long fibonacci(int n)
    {
        long p = 1000000007;
        long v =  (long) (((Math.pow((1 + Math.sqrt(5))/2,n)) - (Math.pow((1 - Math.sqrt(5))/2,n)))/(Math.sqrt(5))) ;
        return v;
    }
    public static void main(String[] args) {

            System.out.print(fibonacci(985)+"   ");

        System.out.println("");
    }
}
