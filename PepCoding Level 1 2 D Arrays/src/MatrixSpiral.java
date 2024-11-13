import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixSpiral {
    public static int[] NearestSmallerValues(int[] arr) {

        int[] res = new int[arr.length];
        int n = arr.length;
        res[0] = -1;
        Arrays.fill(res,-1);
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(NearestSmallerValues(new int[]{2,4,5,1,7})));
    }
}
