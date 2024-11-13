import java.util.Arrays;

public class First_Missing_Positive {
    public static int firstMissingPositive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while ((1 <= arr[i]) && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                // System.out.println(i + " hello");
                if ((1 > arr[i]) || arr[i] > arr.length)
                    break;

            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return arr.length + 1;


    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{10, 4, 16, 54, 17, -7, 21, 15, 25, 31, 61, 1, 6, 12, 21, 46, 16, 56, 54, 12, 23, 20, 38, 63, 2, 27, 35, 11, 13, 47, 13, 11, 61, 39, 0, 14, 42, 8, 16, 54, 50, 12, -10, 43, 11, -1, 24, 38, -10, 13, 60, 0, 44, 11, 50, 33, 48, 20, 31, -4, 2, 54, -6, 51, 6}));
    }
}
