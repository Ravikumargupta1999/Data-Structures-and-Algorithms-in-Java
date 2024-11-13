package InterviewQuestion;

public class Video_94_Max_Sum_In_the_Configuration {
    // https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
    // https://www.youtube.com/watch?v=yroWfS5P2E4
    int max_sum(int arr[], int n) {
        int sum = 0;
        int s0 = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            s0 += (i * arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        int si = s0;
        for (int i = 0; i < n; i++) {
            int temp = si + sum - (n * arr[n - 1 - i]);
            ans = Math.max(ans, temp);
            si = temp;
        }
        return ans;
    }
}
