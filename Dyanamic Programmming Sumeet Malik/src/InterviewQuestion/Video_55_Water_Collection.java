package InterviewQuestion;

public class Video_55_Water_Collection {
    // TC : O(n)
    // SC : O(n)
    int maxWater(int arr[], int n) {
        int[] leftMax = new int[n];
        leftMax[0] = -1;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = max;
            max = Math.max(max, arr[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = -1;
        max = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, arr[i]);
        }

        int res = 0;

        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (arr[i] < min)
                res += (min - arr[i]);
        }
        return res;
    }
}
