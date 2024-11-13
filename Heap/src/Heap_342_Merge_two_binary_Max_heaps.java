public class Heap_342_Merge_two_binary_Max_heaps {
    // https://practice.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1#
    int[] ans;
    int capacity;
    int heap_size;
    void swap(int i, int j) {
        int temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
    }

    public void insert(int val) {
        heap_size += 1;
        ans[heap_size - 1] = val;
        int i = heap_size - 1;
        while (i > 0 && ans[i] > ans[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        ans = new int[n + m];
        heap_size = n;
        for (int i = 0; i < n; i++) {
            ans[i] = a[i];
        }
        for (int i = 0; i < m; i++) {
            insert(b[i]);
        }
        return ans;
    }
}
