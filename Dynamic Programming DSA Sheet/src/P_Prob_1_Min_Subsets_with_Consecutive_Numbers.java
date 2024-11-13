import java.util.Arrays;

public class P_Prob_1_Min_Subsets_with_Consecutive_Numbers {
    //https://practice.geeksforgeeks.org/problems/min-subsets-with-consecutive-numbers0601/1/
    public static int numOfSubset(int[] arr, int n) {
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0)
                count++;
            else {
                if (arr[i] != arr[i - 1] + 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {6, 2, 5, 7, 9, 3};
        System.out.println(numOfSubset(arr, n));

    }
}
