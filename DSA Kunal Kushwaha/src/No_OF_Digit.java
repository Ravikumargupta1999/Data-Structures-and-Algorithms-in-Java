public class No_OF_Digit {
    public static int noOfDigit(int n,int b)
    {
        return (int)(Math.log(n)/Math.log(b)) +1;
    }

    public static void main(String[] args) {
        System.out.println(noOfDigit(8,8));
    }
}
