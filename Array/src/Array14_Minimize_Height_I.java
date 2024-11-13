import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/minimize-the-heights-i/0/#
public class Array14_Minimize_Height_I {
    // https://www.youtube.com/watch?v=VFKgBh164HI
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int r = arr[n - 1] - arr[0];
        for (int i = 1; i < n; i++) {
            int max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            int min = Math.min(arr[i] - k, arr[0] + k);
            // if (min < 0)
            //     continue;
            r = Math.min(r, max - min);

        }
        return r;
    }
}
