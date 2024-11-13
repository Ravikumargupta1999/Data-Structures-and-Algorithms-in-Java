package Weekly_Contest_328;

public class Problem_4 {
    public int differenceOfSum(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums){
            a += num;
            b += digitSum(num);
        }
        return Math.abs(a-b);
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num != 0) {

            sum += (num % 10);
            num = num / 10;
        }
        return sum;
    }
}
