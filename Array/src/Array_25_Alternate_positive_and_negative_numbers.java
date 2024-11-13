import java.util.ArrayList;

public class Array_25_Alternate_positive_and_negative_numbers {
    // Not Constant  Space
    void rearrange(int[] arr, int n) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for (int val : arr) {
            if (val >= 0)
                positive.add(val);
            else
                negative.add(val);
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n) {
            if (j < positive.size())
                arr[i++] = positive.get(j++);
            if (k < negative.size())
                arr[i++] = negative.get(k++);
        }
    }
}
