public class WrapperIntegerExample5 {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        System.out.println(a+"   "+b);
        Integer temp = a;
        a = b;
        b = temp;
        System.out.println(a+"   "+b);
    }
}
