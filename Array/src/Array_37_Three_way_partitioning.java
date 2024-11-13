import java.util.Arrays;


// Done


public class Array_37_Three_way_partitioning {
    // https://www.youtube.com/watch?v=QtpTDMBJqH0&t=271s
    // https://practice.geeksforgeeks.org/problems/three-way-partitioning/1#
    public void threeWayPartition(int array[], int a, int b) {
        Arrays.sort(array);
    }
    public void threeWayPartition1(int array[], int a, int b)
    {
        int l = 0;
        int r = array.length - 1;
        for (int i = 0; i <= r; i++) {
            if (array[i] < a) {
                swap(array, l, i);
                l++;
            } else if (array[i] > b) {
                swap(array, r, i);
                i--;
                r--;
            }
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
