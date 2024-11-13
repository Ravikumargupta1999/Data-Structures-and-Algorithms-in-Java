package Day_1_Arrays;

import java.util.ArrayList;
import java.util.List;

public class Next_Permutation_ {
    // https://practice.geeksforgeeks.org/problems/next-permutation5226/1
    List<Integer> nextPermutation_(int N, int arr[]){
        nextPermutation(arr);
        List<Integer> list = new ArrayList<>();
        for (int ele : arr){
            list.add(ele);
        }
        return list;
    }
    // https://www.youtube.com/watch?v=LuLCLgMElus&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=10
    // https://leetcode.com/problems/next-permutation/submissions/
    public void nextPermutation(int[] nums) {
        int index1 = -1;

        int i = nums.length - 2;

        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                index1 = i;
                break;
            }
            i--;
        }
        if (index1 == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        i = nums.length-1;

        while (i >= 0){
            if(nums[i] > nums[index1]){
                swap(nums,i,index1);
                break;
            }
            i--;
        }
        reverse(nums,index1+1,nums.length-1);
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void reverse(int[] nums, int st, int end) {
        while (st < end) {
            swap(nums, st, end);
            st++;
            end--;
        }
    }


}
