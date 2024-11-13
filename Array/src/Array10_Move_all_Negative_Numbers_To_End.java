import java.util.ArrayList;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1#
//Done
public class Array10_Move_all_Negative_Numbers_To_End {
    public static void main(String[] args) {
        int[] arr = {-12, -11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(arr));
        Rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    // TC : O(n)
    // SC : O(n)
    public static void Rearrange(int[] arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                negative.add(arr[i]);
            else
                positive.add(arr[i]);
        }
        int k = 0;
        for (int i = 0; i < positive.size(); i++) {
            arr[k++] = positive.get(i);
        }
        for (int i = 0; i < negative.size(); i++) {
            arr[k++] = negative.get(i);
        }
    }

    // this will give result but order will not be preserved
    public void segregateElements(int arr[], int n) {
        int j = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

    }
}
