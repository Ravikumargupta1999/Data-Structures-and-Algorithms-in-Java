public class BT_205_Max_Sum_Without_Adjacents {
    // https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1/
    // https://www.youtube.com/watch?v=VT4bZV24QNo
    int findMaxSum(int arr[], int n) {
        int inc = arr[0];
        int exc = 0;
        for (int i = 1; i < n; i++) {

            int ninc = exc + arr[i];

            int nexc = Math.max(exc,inc);

            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc,exc);
    }
}
