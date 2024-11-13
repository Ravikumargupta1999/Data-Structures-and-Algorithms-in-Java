import java.util.Arrays;
import java.util.HashMap;

public class Video_39_SurPasser_Count_Method_2 {
    int[] findSurpasser(int[] arr, int n) {
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = find(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            ans[i] = (n - 1) - i - map.get(arr[i]);
        }
        return ans;
    }

    public HashMap<Integer, Integer> find(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] dup = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(arr[i], 0);
            dup[i] = arr[i];
        }
        mergeSort(dup, 0, n - 1, map);
        return map;
    }
    public void mergeSort(int[] arr, int l, int r, HashMap<Integer, Integer> map) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // Left subArray
            mergeSort(arr, l, m, map);

            // Right suArray
            mergeSort(arr, m + 1, r, map);

            // Merge
            merge(arr, l, m, r, map);
        }

    }
    private void merge(int[] arr, int l, int m, int r, HashMap<Integer, Integer> map) {

        // Left subArray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subArray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, count = 0;

        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                map.put(left[i], map.getOrDefault(left[i], 0) + count);
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count++;
            }
        }
        while (i < left.length) {
            map.put(left[i], map.getOrDefault(left[i], 0) + count);
            arr[k++] = left[i++];
        }
        while (j < right.length)
            arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7};

    }

}
