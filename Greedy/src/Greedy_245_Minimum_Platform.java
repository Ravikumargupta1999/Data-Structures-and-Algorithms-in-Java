import java.lang.reflect.Array;
import java.util.Arrays;

public class Greedy_245_Minimum_Platform {
    // https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
    // https://www.youtube.com/watch?v=dxVcMDI7vyI&t=84s
    static int findPlatform(int[] ari, int[] dep, int n) {
        Arrays.sort(ari);
        Arrays.sort(dep);
        int pf = 1;
        int max = 1;
        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            if (dep[j] >= ari[i]) {
                i++;
                pf++;
                max = Math.max(pf, max);
            } else {
                pf--;
                j++;
            }
        }
        return max;
    }
}
