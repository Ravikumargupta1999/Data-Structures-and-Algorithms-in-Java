public class Video_14_Search_in_Rotated_Sorted_Array {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/
    //https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1
    int search(int arr[], int l, int h, int target) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[l] <= arr[mid]) {
                if (target >= arr[l] && target < arr[mid])
                    h = mid - 1;
                else
                    l = mid + 1;
            } else if (arr[mid] <= arr[h]) {
                if (target > arr[mid] && target <= arr[h])
                    l = mid + 1;
                else
                    h = mid - 1;
            }
        }
        return -1;
    }
}
