public class WrapperIntegerExample4 {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        System.out.println(a+"   "+b);
        swap(a,b);
        System.out.println(a+"   "+b);
    }
    static void swap(Integer a,Integer b)
    {
        Integer temp = a;
        a = b;
        b = temp;
    }
}