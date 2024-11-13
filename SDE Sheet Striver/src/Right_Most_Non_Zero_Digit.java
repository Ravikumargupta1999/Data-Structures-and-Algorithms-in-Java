import java.util.ArrayList;
import java.util.Collections;

public class Right_Most_Non_Zero_Digit {
    public static void main(String[] args) {
        System.out.println(3*6*5*8);
        int[] arr = {10};
        System.out.println(rightmostNonZeroDigit(arr.length, arr));
    }

    static int rightmostNonZeroDigit(int N, int[] A) {
        ArrayList<Integer> res = new ArrayList<>();
        int num = A[0];
        while (num != 0) {
            res.add(num % 10);
            num = num/10;
        }
//        Collections.reverse(res);
////        System.out.println(res);
////        System.out.println();
        for (int i = 1; i < N; i++) {
            multiply(A[i], res);
//            System.out.println(res);
        }
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i) != 0)
                return res.get(i);
        }
        return -1;
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
