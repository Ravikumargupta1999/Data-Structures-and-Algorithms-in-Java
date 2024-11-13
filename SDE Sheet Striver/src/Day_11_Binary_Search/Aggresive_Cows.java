package Day_11_Binary_Search;

import java.util.Arrays;

public class Aggresive_Cows {
    public static int chessTournament(int[] positions, int n,  int c)
    {
        Arrays.sort(positions);
        int low = 1;
        int high = positions[n - 1] - positions[0];
        int res = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (canPlaceCow(positions, c, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static boolean canPlaceCow(int[] positions, int cows, int distance) {
        int count = 1;
        int co_ordinate = positions[0];

        for (int i = 1; i < positions.length; i++) {
            if(positions[i] - co_ordinate >= distance){
                count++;
                co_ordinate = positions[i];
            }
            if(count == cows)
                return true;
        }
        return false;
    }

}
