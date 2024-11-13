import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Maximum_Tip_Calculator {
    class Pair {

        char arr;
        int index;
        int val;

        public Pair(char arr, int val, int index) {
            this.arr = arr;
            this.index = index;
            this.val = val;
        }

    }
//
//    long maxTip(int[] a, int[] b, int n, int x, int y) {
//        Pair[] ans = new Pair[n];
//        for (int i = 0; i < n; i++) {
//            if (a[i] >= b[i]) {
//                Pair p = new Pair('a',a[i], i);
//                ans[i] = p;
//            } else {
//                Pair p = new Pair('b',b[i], i);
//                ans[i] = p;
//            }
//        }
//    }

    public static void main(String[] args) {
        int n = 5, x = 3, y = 3;
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {
                5, 4, 3, 2, 1
        };
    }
}
