

public class Searching_Sorting_103_Search_in_Rotated_Sorted_Array {

    // https://www.youtube.com/watch?v=1uu3g_uu8O0
    public int search1(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == k) {
                return mid;
            } else if (nums[mid] >= nums[l]) {
                if (k <= nums[mid] && k >= nums[l])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (k >= nums[mid] && k <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;

            }
        }
        return -1;

    }

    public int search2(int[] nums, int target) {
        int pivot = findPivot(nums);
        // System.out.println(pivot);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }

    // this will not work in duplicate values
    int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int search3(int[] arr, int target) {
        int l = 0;
        int h = arr.length - 1;
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
