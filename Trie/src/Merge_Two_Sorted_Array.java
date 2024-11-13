import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Two_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = {2,
                4,
                3,
                5,
                2,
                6,
                4,
                5};
        List<Integer> list = new ArrayList<>();
        for (int v : arr)
            list.add(v);
        System.out.println(candies(arr.length, list));
    }

    public static long candies(int n, List<Integer> arr) {
        if (arr.size() == 1)
            return 1;
        else if (arr.size() == 2)
            return 3;
        int min = 0;
        int prev = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                if (arr.get(i) < arr.get(i + 1)) {
                    prev = 1;
                    min = 1;
                } else {
                    prev = 2;
                    min = 2;
                }
            } else if (i == n - 1) {
                if (arr.get(i) > arr.get(i - 1)) {
                    prev = prev + 1;
                    min += prev;
                } else {
                    prev = 1;
                    min += prev;
                }
            } else {
                if (arr.get(i) > arr.get(i - 1)) {
                    prev = prev + 1;
                    min += prev;
                } else if (arr.get(i + 1) >= arr.get(i)) {
                    prev = 1;
                    min += prev;
                } else {
                    prev = 2;
                    min += prev;
                }
            }
            System.out.println(i + "      " + prev + "     " + min);
        }
        return min;
    }

}
