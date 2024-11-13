package Biweekly_Contest_70;

import java.util.Arrays;

public class Minimum_Cost_of_Buying_Candies_With_Discount {
    public int minimumCost(int[] cost) {
        int res = 0;
        Arrays.sort(cost);
        int i = cost.length - 1;
        while (i >= 0) {
            if (i >= 0)
                res += cost[i];
            i--;
            if (i >= 0)
                res += cost[i];
            i--;
            i--;
        }
        return res;
    }
}
