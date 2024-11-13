public class Pattern5 {
    public static void fun(int n)
    {
        for(int i = n ;i>0;i--)
        {
            int temp = i;
            while (temp-- > 0)
                System.out.print(i+" ");
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        fun(5);
    }
}
