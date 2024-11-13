package Day_4_Arrays_;

import java.util.HashMap;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            //  int[] arr=new int[2];
            int sum = nums[i];
            arr[0] = i;
            for (; j < nums.length; j++) {

                if (sum + nums[j] == target)
                    arr[1] = j;
            }
            if (arr[1] != 0)
                break;
        }
        return arr;
    }

    // https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
    int getPairsCount(int[] arr, int n, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int ele : arr) {
            if (map.containsKey(k - ele)) {
                count += map.get(k - ele);
            }
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        return count;
    }
}
