import java.util.ArrayList;
import java.util.Map;

public class Absolute_Difference_of_1 {
    long[] getDigitDiff1AndLessK(long[] arr, int n, long k) {
        ArrayList<Long> list = new ArrayList<>();
        long temp = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 9 && arr[i] < k && finddiff(arr[i])) {
                list.add(arr[i]);
            }
        }
        long[] ans = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static boolean finddiff(long n) {
        long prev = -1;

        while (n != 0) {
            long curr = n % 10;
            if (prev != -1) {
                if(Math.abs(prev-curr) != 1)
                    return false;
            }
            prev = curr;
            n = n /10;
        }
        return true;
    }
}
