public class WrapperIntegerExample1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a+"   "+b);
        swap(a,b);
        System.out.println(a+"   "+b);
    }
    static void swap(int a,int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
}
