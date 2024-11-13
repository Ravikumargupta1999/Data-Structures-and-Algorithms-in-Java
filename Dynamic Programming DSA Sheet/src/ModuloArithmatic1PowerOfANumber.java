public class ModuloArithmatic1PowerOfANumber {
    public static void main(String[] args) {
        int value = FastPower(2, 10); //int value = FastPower(34556,10);
        //int value = FastPower(34556,10); Integer overflow
        //Solution in ModuloArithmatic3
        System.out.println(value);

    }

    public static int FastPower(int a, int b) {
        int result = 1;
        while (b > 0) {
            if ((b & 1) != 0)
                result *= a;
            a = a * a;
            b = b >> 1;
        }
        return result;
    }
}
