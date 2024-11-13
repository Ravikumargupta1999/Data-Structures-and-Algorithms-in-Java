public class Heap_351_Min_Heap_To_Max_Heap {
    static void maxHeapify(int[] arr, int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < n && arr[l] > arr[i])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, n);
        }
    }

    static void convertMaxHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; --i) {
            System.out.println(arr[i]);
            maxHeapify(arr, i, n);
        }
    }
    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // driver program
    public static void main(String[] args) {
        // array representing Min Heap
        int[] arr = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int n = arr.length;

        System.out.print("Min Heap array : ");
        printArray(arr, n);

        convertMaxHeap(arr, n);

        System.out.print("Max Heap array : ");
        printArray(arr, n);
    }
}