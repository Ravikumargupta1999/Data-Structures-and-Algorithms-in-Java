import java.util.HashMap;

public class D_Dynamic_Programming_465_Largest_SubMatrix_With_Equal_0_and_1 {
    // https://www.youtube.com/watch?v=ynkRKGFkX-A
    // https://www.codingninjas.com/codestudio/problems/largest-submatrix-with-equal-number-of-0-s-and-1-s_1062689?leftPanelTab=1
    static int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                int start = map.get(sum);
                int len = i - start;
                if (len > maxLength)
                    maxLength = len;
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static int maximumArea(int[][] mat, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][j] = -1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int j = i; j < n; j++) {
                for (int col = 0; col < m; col++) {
                    temp[col] += mat[j][col];
                }
                max = Math.max(max, maxLen(temp, temp.length) * (j - i + 1));
            }
        }
        return max;
    }

}
