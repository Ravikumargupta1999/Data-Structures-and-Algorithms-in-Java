package InterviewQuestion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Video_41_Star_Elements {
    public static int[] getStarAndSuperStar(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[n - 1]);
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
                max = arr[i];
            }
        }

        Collections.reverse(list);

        boolean[] left = new boolean[n];
        left[0] = true;
        max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                left[i] = true;
            }
        }

        boolean[] right = new boolean[n];
        right[n - 1] = true;
        max = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                right[i] = true;
            }
        }


        list.add(0,-1);
        for (int i = 0; i < n; i++) {
            if (left[i] && right[i])
                list.set(0, arr[i]);
        }

        if(list.get(0) == Integer.MIN_VALUE)
            list.set(0,-1);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {2, 10, 3, 4, 5, 8, 10, 4};
        System.out.println(Arrays.toString(getStarAndSuperStar(arr, arr.length)));
    }
}
