import java.util.Arrays;

public class Video_17_Median_of_Two_Sorted_Arrays {
    // https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1/
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length || j < arr2.length) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] <= arr2[j])
                    arr[k++] = arr1[i++];
                else
                    arr[k++] = arr2[j++];
            } else if (i < arr1.length) {
                arr[k++] = arr1[i++];
            } else if (j < arr2.length) {
                arr[k++] = arr2[j++];
            }
        }
        System.out.println(Arrays.toString(arr));
        if (arr.length == 1)
            return arr[0];
        else if (arr.length == 2) {
            double a = arr[0];
            double b = arr[1];
            double ans = (a + b) / 2;
            return ans;
        } else if (arr.length % 2 == 1) {
            double ans = arr[(arr.length / 2)];
            return ans;
        } else {
            double a = arr[(arr.length / 2) - 1];
            double b = arr[(arr.length / 2)];
            double ans = (a + b) / 2;
            return ans;
        }
    }
}
