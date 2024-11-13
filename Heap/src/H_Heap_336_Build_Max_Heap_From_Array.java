import java.util.Arrays;

public class H_Heap_336_Build_Max_Heap_From_Array {
    // https://www.youtube.com/watch?v=cuL8gXCSA58&list=PLEJXowNB4kPyP2PdMhOUlTY6GrRIITx28&index=5
    // https://www.geeksforgeeks.org/building-heap-from-array/
    public static void Max_Heap(int[] arr) {
        for (int i = (arr.length / 2 - 1); i >= 0; i--) {
            heapify(arr, i);
            System.out.println(Arrays.toString(arr));
        }
        return;
    }

    public static void heapify(int[] arr, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < arr.length && arr[l] > arr[i])
            largest = l;
        else
            largest = i;
        if (r < arr.length && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
//        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println("");

        Max_Heap(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println("");
    }
}
