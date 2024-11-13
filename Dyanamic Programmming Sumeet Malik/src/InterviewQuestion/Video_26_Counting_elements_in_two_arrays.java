package InterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;

public class Video_26_Counting_elements_in_two_arrays {
    // Method 1;
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int ele1 : arr1) {
            int count = 0;
            for (int ele : arr2) {
                if (ele <= ele1)
                    count++;
            }
            list.add(count);
        }
        return list;
    }

    public static ArrayList<Integer> countEleLessThanOrEqual1(int arr1[], int arr2[], int m, int n)
    {
        Arrays.sort(arr2);
        ArrayList<Integer> list = new ArrayList<>();
        for (int ele : arr1) {
            list.add(search(arr2, ele));
        }
        return list;
    }

    public static int search(int[] arr, int element) {
        if (element < arr[0])
            return 0;
        else if (element > arr[arr.length - 1])
            return arr.length;
        int left = 0;
        int right = arr.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= element) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index+1;
    }
}
