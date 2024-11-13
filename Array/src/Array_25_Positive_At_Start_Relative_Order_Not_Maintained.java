import java.util.Arrays;

public class Array_25_Positive_At_Start_Relative_Order_Not_Maintained {
    static void rearrange(int arr[], int n) {

        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i < n && arr[i] >= 0)
                i++;
            while (j >= 0 && arr[j] < 0)
                j--;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;

        }
        int left = 0;
        int right = -1;
        for (int l = 0; l < arr.length; l++) {
            if (arr[l] < 0) {
                right = l;
                break;
            }
        }
        while (right < n && left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left += 2;
            right++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {9, 4, -5, 0, -3, 2};
        System.out.println(Arrays.toString(arr));
        rearrange(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }
}
