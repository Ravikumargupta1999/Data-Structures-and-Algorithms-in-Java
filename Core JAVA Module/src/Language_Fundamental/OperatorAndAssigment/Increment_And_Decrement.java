package Language_Fundamental.OperatorAndAssigment;

public class Increment_And_Decrement {
    public static void main(String[] args) {
        int x = 10;
//        int y = ++x;
//        System.out.println(x+"  "+y);

//        int y = x++;
//        System.out.println(x+"  "+y);

//        int y = --x;
//        System.out.println(x+"  "+y);

        int y = x--;
        System.out.println(x + "  " + y);

        char ch = 'a';
        ch++;
        System.out.println(ch++);
        System.out.println(ch);

        System.out.println("\n\n\n");

        byte b = 10;
//        b = b +1;
        b++;
        System.out.println(b);
        System.out.println("\n\n\n");

        byte l = 10;
        byte m = 20;
//        byte n = l + m;
        byte n = (byte) (l + m);
        System.out.println(n);


    }
}
