package Weekly_Contest_327;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximal_Score_After_Applying_K_Operations {
    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
        System.out.println(maxKelements(nums, k));
    }

    public static long maxKelements(int[] nums, int k) {

        long score = 0;
        Arrays.sort(nums);
        int j = nums.length - 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });
        for (int i = 0; i < nums.length; i++)
            queue.add(new int[]{i, nums[i]});
        while (k-- > 0) {
            int[] pop = queue.poll();
            score += (pop[1]);

            pop[1] = pop[1] % 3 == 0 ? pop[1] / 3 : pop[1] / 3 + 1;

            queue.add(pop);
        }
        return score;
    }
}
