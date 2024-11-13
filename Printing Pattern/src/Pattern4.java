public class Pattern4 {
    public static void fun(int n)
    {
        for(int i = n ;i>=1;i--)
        {
            int temp = i;
            while (temp-- > 1)
                System.out.print(temp+" ");
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        fun(6);
    }
}
