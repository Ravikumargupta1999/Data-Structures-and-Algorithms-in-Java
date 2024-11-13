public class ModuloArithmatic1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        if ((a & 1) != 0)
            System.out.println("a is odd");
        else
            System.out.println("a is even");
        if ((b & 1) != 0)
            System.out.println("b is odd");
        else
            System.out.println("b is even");
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("a >> 1 : " + (a >> 1));
        System.out.println("a << 1 : " + (a << 1));
        System.out.println("b >> 1 : " + (b >> 1));
        System.out.println("b << 1 : " + (b << 1));


        System.out.println();
        System.out.println();
        System.out.println();
    }
}
