import java.util.HashMap;
import java.util.HashSet;

public class Product_Pair {
    boolean isProduct(int[] arr, int n, long x) {
        if (x == 0) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    return true;
                }
            }
            return false;
        }
        HashSet<Long> set = new HashSet<>();
        for (int ele : arr) {
            if(ele == 0 || x % ele != 0)
                continue;
            Long required = (long) x/ele;
            if(set.contains(required))
                return true;
            set.add((long)ele);
        }
        return false;
    }
}
