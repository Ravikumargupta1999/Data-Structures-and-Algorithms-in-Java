public class Sum_of_digit {
    public static int sumOfDigit(int n,int sum)
    {
        if( n == 0)
            return sum;
        int val = n%10;
        return sumOfDigit(n/10,sum+val);
    }
    public static void main(String[] args) {
        System.out.println(sumOfDigit(45632,0));
    }
}
