import java.util.ArrayList;
import java.util.Arrays;

public class Find_all_factorial_numbers_less_than_or_equal_to_N {
    static ArrayList<Long> factorialNumbers(long n) {
        long[] arr = new long[100];
        arr[1] = (long) 1;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] * i > Math.pow(10, 18)) {
                arr[i] = (long) -1;
                break;
            } else {
                arr[i] = arr[i - 1] * i;
            }
        }
        ArrayList<Long> ans = new ArrayList<>();
        for (int i = 1; i < arr.length && arr[i] <= n; i++) {
            if (arr[i] < 0)
                break;
            ans.add(arr[i]);

        }
        return ans;
    }

    public static void main(String[] args) {
        long val = Long.MAX_VALUE;
        System.out.println(factorialNumbers(val));
    }
}
