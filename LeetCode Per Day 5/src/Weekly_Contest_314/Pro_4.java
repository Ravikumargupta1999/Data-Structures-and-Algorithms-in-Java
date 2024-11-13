package Weekly_Contest_314;

import java.util.Arrays;

public class Pro_4 {
    public int hardestWorker(int n, int[][] logs) {
        int max = logs[0][1];
        int end = logs[0][1];
        int ans = logs[0][0];

        for (int i = 1; i < logs.length; i++) {
            if (logs[i][1] - end > max) {
                max = logs[i][1] - end;
                ans = logs[i][0];
            } else if (logs[i][1] - end == max) {
                ans = Math.min(ans, logs[i][0]);
            }
            end = logs[i][1];
        }
        return ans;
    }

    public static int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        int[] temp = new int[pref.length];
        res[0] = pref[0];
        temp[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            res[i] = pref[i] ^ temp[i - 1];
            temp[i] = temp[i-1]^res[i];

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,0,3,1};
        System.out.println(Arrays.toString(findArray(arr)));
    }
}
