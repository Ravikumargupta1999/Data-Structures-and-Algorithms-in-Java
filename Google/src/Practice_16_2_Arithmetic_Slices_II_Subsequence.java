import java.util.HashMap;


public class Practice_16_2_Arithmetic_Slices_II_Subsequence {
    // https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
    // https://www.youtube.com/watch?v=XjLT4TaXsgw&t=683s
    public int numberOfArithmeticSlices(int[] arr) {
        HashMap<Integer, Integer>[] map = new HashMap[arr.length];
        for (int i = 0; i < map.length; i++)
            map[i] = new HashMap<>();
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                long cd = (long) arr[i] - (long) arr[j];
                if (cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE)
                    continue;
                int apJ = map[j].getOrDefault((int) cd, 0);
                int apI = map[i].getOrDefault((int) cd, 0);
                ans += apJ;
                map[i].put((int) cd, apI + apJ + 1);
            }
        }
        return ans;

    }
}
