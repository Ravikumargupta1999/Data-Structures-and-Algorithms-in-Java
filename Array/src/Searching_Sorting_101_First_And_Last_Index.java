import java.util.ArrayList;

// Done

public class Searching_Sorting_101_First_And_Last_Index {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
    public int[] searchRange(int[] arr, int target) {

        int[] ans = {-1, -1};
        int start = search(arr, target, true);
        int end = search(arr, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    public int search(int[] arr, int target, boolean firstIndex) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target)
                start = mid + 1;
            else if (arr[mid] > target)
                end = mid - 1;
            else {
                ans = mid;
                if (firstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;


    }


    // https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
    public ArrayList<Integer> firstAndLast(int[] arr, int n, int x) {
        int lo = 0;
        int hi = n - 1;
        int fi = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (x > arr[mid])
                lo = mid + 1;
            else if (x < arr[mid])
                hi = mid - 1;
            else {
                fi = mid;
                hi = mid - 1;
            }
        }

        lo = 0;
        hi = n - 1;
        int li = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (x > arr[mid])
                lo = mid + 1;
            else if (x < arr[mid])
                hi = mid - 1;
            else {
                li = mid;
                lo = mid + 1;
            }
        }

        ArrayList<Integer> al = new ArrayList<>();
        if (li == -1) {
            al.add(-1);
            return al;
        }
        al.add(fi);
        al.add(li);
        return al;
    }
}
