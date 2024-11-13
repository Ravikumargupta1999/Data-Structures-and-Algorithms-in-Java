import java.util.Arrays;

public class Array_25_Negative_At_Start_Relative_Order_Not_Maintained {
    static void rearrange(int arr[], int n) {

        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (arr[i] < 0)
                i++;
            else if (arr[j] > 0)
                j--;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        System.out.println(Arrays.toString(arr));
        rearrange(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }
}
