public class WrapperIntegerExample2 {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
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
