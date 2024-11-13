
import java.util.Arrays;


public class Heap_337_Heap_Sort {
    // https://practice.geeksforgeeks.org/problems/heap-sort/1#
    static void heapify(int[] arr, int n, int i) {
        System.out.println("Heap ify : "+Arrays.toString(arr)+"   "+n+"    "+0);
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l <= n && arr[l] > arr[i])
            largest = l;

        if (r <= n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    //Function to sort an array using Heap Sort.
    public static void heapSort(int[] arr, int n) {
        for (int i = (arr.length / 2 - 1); i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }

    }

    public static void main(String[] args) {
        int[] arr ={10,7,8,6,9};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
