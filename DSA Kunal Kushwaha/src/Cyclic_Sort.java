import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
public class Cyclic_Sort {
    public static void cyclicSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                System.out.println(i + " hello");
            }
        }
    }

    public static void cyclicSort1(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct])
                swap(arr, i, correct);
            else
                i++;
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 4};
        cyclicSort1(arr);
        System.out.println(Arrays.toString(arr));
        ;
    }
}
