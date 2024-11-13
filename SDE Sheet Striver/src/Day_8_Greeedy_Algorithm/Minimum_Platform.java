package Day_8_Greeedy_Algorithm;

import java.util.Arrays;

public class Minimum_Platform {
    static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int res = 1;
        int platform = 1;
        int j = 0;
        int i = 1;

        while (i < n && j <n) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
                res =Math.max(res,platform);
            } else {
                platform--;
                j++;
            }
        }
        return res;
    }
}
