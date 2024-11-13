public class Practice_6_Convert_Array_Into_Zig_Zag_Fashion {
    // https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1?page=13&company[]=Amazon&sortBy=submissions

    void zigZag(int[] arr, int n) {
        if (n == 1)
            return;

        if (arr[0] > arr[1]) {
            swap(arr, 0, 1);
        }

        for (int i = 1; i < n - 1; i++) {
            if (i % 2 != 0) {
                if (arr[i] < arr[i + 1])
                    swap(arr, i, i + 1);
            } else {
                if(arr[i] > arr[i+1])
                    swap(arr,i,i+1);

            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
