package Biweekly_Contest_67;

import java.util.Arrays;
import java.util.HashMap;

public class Find_Subsequence_of_Length_K_With_the_Largest_Sum {
    public static void main(String[] args) {
        int[] arr = {2,1};
        System.out.println(Arrays.toString(maxSubsequence(arr,2)));
    }
    public static int[] maxSubsequence(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i=0;i<nums.length;i++)
            temp[i] = nums[i];
        Arrays.sort(nums);
        int[] ans = new int[k];
        int i = nums.length-1;
        int j = ans.length-1;
        while (k-- > 0){
            ans[j--] = nums[i--];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : ans)
            map.put(num,map.getOrDefault(num,0)+1);
//        System.out.println(Arrays.toString(ans)+"   "+map);
        i = 0;
        for (int num : temp){
            System.out.println(num);
            if(map.containsKey(num)) {
                ans[i++] = num;
//                System.out.println(Arrays.toString(ans));
                if(map.get(num) == 1)
                    map.remove(num);
                else
                    map.put(num,map.get(num)-1);
            }
        }
        return ans;
    }
}
