package Language_Fundamental.Literals;

public class Octal_Literals {
    public static void main(String[] args) {
        int x = 0123;
        System.out.println(x);
        int y = 0456; // y = 090 will be wrong as it contains 9 which does not lie in range 0-9;

        System.out.println(y);
    }
}
