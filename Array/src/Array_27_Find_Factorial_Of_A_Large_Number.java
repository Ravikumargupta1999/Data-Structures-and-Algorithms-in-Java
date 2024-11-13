import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

// Done
public class Array_27_Find_Factorial_Of_A_Large_Number {

    public static BigInteger Factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        int factorialNo = n;

        for (int i = 2; i <= factorialNo; i++) {
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }
        return fact;
    }

    static ArrayList<Integer> factorial1(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 2; i <= n; i++) {
            multiply(i, res);
        }
        Collections.reverse(res);
        return res;
    }

    static void multiply(int x, ArrayList<Integer> list) {
        int carry = 0;
        for (int i = 0; i < list.size(); i++) {
            int prod = x * list.get(i);
            prod += carry;
            list.set(i, prod % 10);
            carry = prod / 10;
        }
        while (carry != 0) {
            list.add(carry % 10);
            carry = carry / 10;
        }
    }
}
