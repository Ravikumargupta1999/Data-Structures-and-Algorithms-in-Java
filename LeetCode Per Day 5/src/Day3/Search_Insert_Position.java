package Day3;

public class Search_Insert_Position {
    // https://leetcode.com/problems/search-insert-position/submissions/
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}
