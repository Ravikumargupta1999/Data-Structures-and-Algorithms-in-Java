import java.util.Arrays;

public class Searching_Sorting_113_Maximum_Triplet_Sum {
    int maxTripletSum1(int a[], int n) {
        Arrays.sort(a);
        return a[n - 1] + a[n - 2] + a[n - 3];
    }
    // https://practice.geeksforgeeks.org/problems/maximum-triplet-sum-in-array0129/0/#
    // Task is to find top 3 element in o(n) time
    int maxTripletSum(int[] arr, int n) {
        int first = arr[0];
        int second = Integer.MIN_VALUE;
        int third = second;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] < first && arr[i] >= second) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third && arr[i] <= second)
                third = arr[i];
        }
        return third + second + first;

    }
}
