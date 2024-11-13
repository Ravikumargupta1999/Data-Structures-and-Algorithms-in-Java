package Day_2_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Find_The_Duplicate_Number {
    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 2};
//        System.out.println(findDuplicate1(arr));
        System.out.println(duplicates(arr, arr.length));
    }

    // wrong
    // https://leetcode.com/problems/find-the-duplicate-number/
    public static int findDuplicate(int[] nums) {
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            System.out.println(i);
            res = res ^ i;
        }
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    // correct
    // https://leetcode.com/problems/find-the-duplicate-number/
    public static int findDuplicate1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int index = nums[i] - 1;
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return nums.length;
    }


    // https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        for (int i = 0; i < n; i++) {

            while (arr[i] != i && arr[i] != arr[arr[i]]) {
                int index = arr[i];
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i && !set.contains(arr[i])) {
                set.add(arr[i]);
                list.add(arr[i]);
            }
        }
        if (list.size() == 0)
            list.add(-1);
        Collections.sort(list);
        return list;

    }

}
