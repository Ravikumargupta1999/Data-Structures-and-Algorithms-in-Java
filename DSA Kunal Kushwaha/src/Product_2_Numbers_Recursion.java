public class Product_2_Numbers_Recursion {
    static int product(int a,int b)
    {
        if(a < b)
        {
            product(b,a);
        }
        if( b != 0)
            return a + product(a,b-1);
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(product(4,10));
    }
}
