import java.util.ArrayList;

public class Video_12_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    // https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x2041/1/
    public ArrayList<Integer> firstAndLast(int[] nums, int n, int target){
        int[] ans = {-1, -1};
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(ans[0]);
        al.add(ans[1]);
        if(al.get(al.size()-1) == -1)
            al.remove(al.size()-1);
        return al;
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
}
