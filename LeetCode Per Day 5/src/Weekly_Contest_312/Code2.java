package Weekly_Contest_312;

public class Code2 {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int and = nums[i];
            int len = 1;
            if(and > max){
                max = and;
                res = len;
            }else if(and == max){
                res = Math.max(res,len);
            }
            for (int j = i + 1; j < nums.length; j++) {
                and = and & nums[j];
                len++;
                if(and > max){
                    max = and;
                    res = len;
                }else if(and == max){
                    res = Math.max(res,len);
                }
            }
        }
        return res;
    }
}
