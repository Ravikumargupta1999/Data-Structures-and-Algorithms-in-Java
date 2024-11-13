public class Searching_Sorting_134_Count_Inversions {
    // Method 1 - Brute Force
    // TC : O(n^2)
    // SC : O(1)
    public static int CountInversion(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    count++;
            }
        }
        return count;
    }

    // Method 2
    static long inversionCount(long arr[], long n) {
        long[] temp = new long[(int) n];
        long count = mergeSort(arr, temp, 0, n - 1);
        return count;

    }

    public static long mergeSort(long[] arr, long[] temp, long l, long r) {
        long inv = 0;
        if (l < r) {
            long mid = (l + r) / 2;
            inv += mergeSort(arr, temp, l, mid);
            inv += mergeSort(arr, temp, mid + 1, r);
            inv += merge(arr, temp, l, mid + 1, r);

        }
        return inv;
    }

    public static long merge(long[] arr, long[] temp, long l, long mid, long r) {
        long i, j, k, inv = 0;
        i = l;
        j = mid;
        k = l;
        while (i <= mid - 1 && j <= r) {
            if (arr[(int) i] <= arr[(int) j]) {
                temp[(int) k++] = arr[(int) i++];
            } else {
                temp[(int) k++] = arr[(int) j++];
                inv += (mid - i);
            }
        }
        while (i <= mid - 1) {
            temp[(int) k++] = arr[(int) i++];
        }
        while (j <= r) {
            temp[(int) k++] = arr[(int) j++];
        }
        for (long d = l; d <= r; d++)
            arr[(int) d] = temp[(int) d];
        return inv;

    }
}
