package Biweekly_Contest_97;

import java.util.HashSet;

public class Problem_2 {
    public static void main(String[] args) {

    }

    public int maxCount(int[] banned, int n, int maxSum) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : banned)
            set.add(num);
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (set.contains(i))
                continue;
            sum += i;
            count++;
            if (sum > maxSum)
                return count - 1;
            else if (sum == maxSum)
                return count;
        }
        return count;
    }
}
