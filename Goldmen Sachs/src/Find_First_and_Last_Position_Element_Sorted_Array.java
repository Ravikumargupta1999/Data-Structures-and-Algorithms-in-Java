// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
// https://www.youtube.com/watch?v=W9QJ8HaRvJQ
// 1:24:25
public class Find_First_and_Last_Position_Element_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = search(nums,target,true);
        int end = search(nums,target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    public int search(int[] arr,int target,boolean firstIndex)
    {
        int ans = -1;
        int start = 0;
        int end = arr.length-1;
        while (start <= end)
        {
            int mid = start + (end-start)/2;
            if(arr[mid] < target)
                start = mid + 1;
            else if(arr[mid] > target)
                end = mid-1;
            else
            {
                ans = mid;
                if(firstIndex)
                {
                    end = mid-1;
                }
                else
                {
                    start = mid +1;
                }
            }
        }
        return ans;

    }
}
