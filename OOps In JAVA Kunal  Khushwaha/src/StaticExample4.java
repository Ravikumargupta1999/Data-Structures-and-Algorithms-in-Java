public class StaticExample4 {
    static int a = 4;
    static int b; // by default it will be initialized with 0
    static {
        System.out.println("I am static Block");
         b *= a;
        System.out.println(a+"   "+b);
    }

    public static void main(String[] args) {
        System.out.println("\nI am main function");
        System.out.println(a+"   "+b);
    }
}
