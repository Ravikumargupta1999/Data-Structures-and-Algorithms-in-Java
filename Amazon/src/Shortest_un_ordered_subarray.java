//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/submissions/
public class Shortest_un_ordered_subarray {
    //https://practice.geeksforgeeks.org/problems/shortest-un-ordered-subarray3634/1/?company[]=Oracle&company[]=Oracle&page=2&query=company[]Oraclepage2company[]Oracle#
    //https://leetcode.com/problems/shortest-unsorted-continuous-subarray/submissions/
    public int findUnsortedSubarray(int[] nums) {
        int end = -1;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max > nums[i])
                end = i;
            else
                max = nums[i];
        }
        int st = 0;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min)
                st = i;
            else
                min = nums[i];
        }
        return end - st + 1;

    }

    //
    public long shortestUnorderedSubarray(long arr[], long n) {
        long end = -1;
        long max = arr[0];
        for (long i = 1; i < arr.length; i++) {
            if (max > arr[(int) i])
                end = i;
            else
                max = arr[(int) i];
        }
        long st = 0;
        long min = arr[(int) arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > min)
                st = i;
            else
                min = arr[(int) i];
        }
        return end - st + 1;
    }

}
