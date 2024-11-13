import java.util.Arrays;

public class Recursive_Bubble_Sort {
    public static int[] bubbleSort(int[] arr) {
        bubble(arr, arr.length);
        return arr;
    }

    public static void bubble(int[] arr, int index) {
        if (index == 1)
            return;
        boolean swap = false;
//        System.out.println(index);
        for (int i = 0; i < index - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                swap = true;
            }
        }
        if (!swap)
            return;
        bubble(arr, index - 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{64, 34, 25, 12, 22, 11, 90})));
    }
}
