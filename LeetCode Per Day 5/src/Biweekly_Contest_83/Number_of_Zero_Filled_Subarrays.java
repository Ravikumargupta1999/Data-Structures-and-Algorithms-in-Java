package Biweekly_Contest_83;

public class Number_of_Zero_Filled_Subarrays {
    public static void main(String[] args) {
        int[] arr = {1,3,0,0,2,0,0,4};
        System.out.println(zeroFilledSubarray(arr));
    }
    public static long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int count = 0;
        for (int num : nums){
            if(num == 0)
                count++;
            else
                count = 0;
            res += count;
            System.out.println(num+"  "+res+"   "+count);
        }
        return res;
    }
}
