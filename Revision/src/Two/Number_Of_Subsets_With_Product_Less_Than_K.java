package Two;

public class Number_Of_Subsets_With_Product_Less_Than_K {
    static int res = 0;

    static void helper(int arr[], int N, int ind, int k, int pro) {
        if (ind == N) {
            if (pro <= k) {
                res++;
            }
            return;
        }
        if (pro > k) {
            return;
        }
        helper(arr, N, ind + 1, k, pro);
        helper(arr, N, ind + 1, k, pro * arr[ind]);
    }

    static int numOfSubsets(int[] arr, int N, int K) {
        res = 0;
        helper(arr, N, 0, K, 1);
        return res - 1;
    }
}
