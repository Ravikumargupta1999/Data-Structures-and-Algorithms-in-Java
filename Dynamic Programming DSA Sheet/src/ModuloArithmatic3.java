import java.util.Scanner;

public class ModuloArithmatic3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long value = FastPower(3978432, 5, 1000000007);
        System.out.println(value);
    }

    public static long FastPower(long a, long b, int n) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) != 0) result = (result * a % n) % n;
            a = (a % n * a % n) % n;
            b = b >> 1;
        }
        return result;
    }
}
