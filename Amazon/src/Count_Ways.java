public class Count_Ways {
    static public long nthStair(int n)
    {
        if(n == 1)
            return 1;
        else if(n < 0)
            return 0;
        System.out.println("Ravi : "+n);
        long n1 = nthStair(n-1);
        long n2 = nthStair(n-2);



        long count_paths = Math.min(n1,n2) ;

        return count_paths;
    }
    public static void main(String[] args) {
     System.out.println(nthStair(5));
    }
}
