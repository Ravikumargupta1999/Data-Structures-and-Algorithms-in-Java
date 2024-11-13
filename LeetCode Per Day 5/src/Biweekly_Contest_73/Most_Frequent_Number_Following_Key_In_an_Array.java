package Biweekly_Contest_73;

import java.util.HashMap;

public class Most_Frequent_Number_Following_Key_In_an_Array {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == key) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        int max = 0;
        int res = 0;
        for (int num : map.keySet()){
            if(map.get(num) > max){
                max = map.get(num);
                res = num;
            }
        }
        return res;
    }
}
