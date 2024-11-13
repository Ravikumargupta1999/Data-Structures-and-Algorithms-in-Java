public class Make_a_Distinct_Digit_Array {
    public int[] common_digits(int[] nums) {
        boolean[] flag = new boolean[11];
        int count = 0;
        for (int num : nums) {
            while (num != 0) {
                int digit = num % 10;
                num = num / 10;
                if (!flag[digit]) {
                    flag[digit] = true;
                    count++;
                }
            }
        }
        int[] res = new int[count];
        int j = 0;
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i])
                continue;
            res[j++] = i;
        }
        return res;

    }
}
