package Weekly_Contest_323;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Delete_Greatest_Value_In_Each_Row {
    public int deleteGreatestValue(int[][] grid) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int[] arr : grid) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int val : arr)
                temp.add(val);
            Collections.sort(temp);
            list.add(temp);
        }

        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max,list.get(j).get(i));
            }
            ans += max;
        }
        return ans;
    }
}
