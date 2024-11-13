package Biweekly_Contest_22;

public class Find_the_Distance_Value_Between_Two_Arrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int num1 : arr1) {
            boolean flag = false;
            for (int num2 : arr2) {
                if(Math.abs(num1-num2) <= d){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                ans++;
        }
        return ans;
    }
}
