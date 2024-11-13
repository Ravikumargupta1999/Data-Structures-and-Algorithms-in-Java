import java.util.*;

// https://www.hackerrank.com/challenges/board-cutting/problem
// https://www.youtube.com/watch?v=9DckVBRzuQU
public class Greedy_249_Minimum_Cost_to_Cut_a_Board_Into_Squares {
    // https://practice.geeksforgeeks.org/problems/minimum-cost-to-cut-a-board-into-squares/1/
    // https://www.youtube.com/watch?v=9DckVBRzuQU
    public static int minimumCostOfBreaking(int[] cost_x, int[] cost_y, int M, int N) {
        Arrays.sort(cost_x);
        Arrays.sort(cost_y);
        reverse(cost_x);
        reverse(cost_y);

        int ans = 0;
        int i = 0;
        int j = 0;
        int m = cost_x.length;
        int n = cost_y.length;
        int horizontalCount = 1;
        int verticalCount = 1;
        int p = 1000000007;
        while (i < m && j < n) {
            if (cost_x[i] > cost_y[j]) {
                ans = ans % p + (cost_x[i] * verticalCount) % p;
                horizontalCount++;
                i++;
            } else {
                ans = ans % p + (cost_y[j] * horizontalCount) % p;
                verticalCount++;
                j++;
            }
        }
        while (i < m) {
            ans = ans % p + (cost_x[i] * verticalCount) % p;
            i++;
        }
        while (j < n) {
            ans = ans % p + (cost_y[j] * horizontalCount) % p;
            j++;
        }
        return ans % p;
    }

    public static void reverse(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
