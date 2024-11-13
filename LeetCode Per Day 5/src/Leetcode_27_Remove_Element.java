import java.util.Arrays;

public class Leetcode_27_Remove_Element {
//    [0,1,2,2,3,0,4,2], val = 2
    // https://leetcode.com/problems/remove-element/submissions/
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;

        while (i < n && j >= 0 && i <= j) {
//            System.out.println(Arrays.toString(nums) + "  " + i + "  " + j);
            while (i < n && nums[i] != val)
                i++;
//            System.out.println(i);
            while (j >= 0 && nums[j] == val)
                j--;
//            System.out.println(j);
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
//            System.out.println(Arrays.toString(nums) + "  " + i + "  " + j);
        }
//        System.out.println("");
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int k = removeElement(arr, 2);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
