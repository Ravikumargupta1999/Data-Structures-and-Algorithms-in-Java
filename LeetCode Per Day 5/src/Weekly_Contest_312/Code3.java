package Weekly_Contest_312;

import java.util.ArrayList;
import java.util.List;

public class Code3 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2};
        System.out.println(goodIndices(arr, 2));
    }

    public static List<Integer> goodIndices(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - k < 0 || i + k >= nums.length)
                continue;

            boolean flag = true;
            for (int j = 2; j <= k; j++) {

                if (nums[i - j] < nums[i - j + 1]) {
                    flag = false;
                    break;
                }

            }
            if (!flag)
                continue;
            for (int j = 2; j <= k; j++) {

                if (nums[i + j] < nums[i + j - 1]) {
                    flag = false;
                    break;
                }

            }
            if (flag)
                list.add(i);

        }
        return list;
    }
}
