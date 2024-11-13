public class Sum_Of_Natural_Number {
    public static int sum(int n,int sum)
    {
        if(n < 1)
            return sum;
        return sum(n-1,sum+n);
    }
    public static void main(String[] args) {
        System.out.println(sum(10,0));
    }
}
