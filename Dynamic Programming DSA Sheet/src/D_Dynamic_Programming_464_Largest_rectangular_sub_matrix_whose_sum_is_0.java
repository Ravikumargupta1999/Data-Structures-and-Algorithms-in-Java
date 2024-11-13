import java.util.HashMap;

public class D_Dynamic_Programming_464_Largest_rectangular_sub_matrix_whose_sum_is_0 {
    // https://www.youtube.com/watch?v=eXA3F2WN3d0
    // https://www.codingninjas.com/codestudio/problems/sub-matrix-with-sum-zero_1063254?leftPanelTab=1
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

    public static int largestSubMatrixWithSumZero(int[][] mat, int n, int m) {
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
