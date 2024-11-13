// https://www.youtube.com/watch?v=TdMAsIIM_n8&list=PLEJXowNB4kPyP2PdMhOUlTY6GrRIITx28&index=8

public class Heap_336_Max_Heap_Implementation {
    static int[] arr;
    static int capacity;
    static int heap_size;

    Heap_336_Max_Heap_Implementation(int cap) {
        heap_size = 0;
        capacity = cap;
        arr = new int[cap];
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void maxHeapify(int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest;
        if (left < n && arr[left] > arr[i])
            largest = left;
        else
            largest = i;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            swap(i, largest);
            maxHeapify(n, largest);
        }
    }

    public static int extractMax() {
        if (heap_size < 1)
            return -1;
        int max = arr[0];
        arr[0] = arr[heap_size - 1];
        heap_size -= 1;
        maxHeapify(heap_size, 0);
        return max;
    }

    public static void insert(int val) {
        heap_size += 1;
        arr[heap_size - 1] = val;
        int i = heap_size - 1;
        while (i > 0 && arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    void deleteKey(int i) {
        if (i < 0 || i >= heap_size)
            return;
        decreaseKey(i, Integer.MAX_VALUE);
        extractMax();
    }

    void decreaseKey(int i, int val) {
        arr[i] = val;
        while (i > 0 && arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
}
