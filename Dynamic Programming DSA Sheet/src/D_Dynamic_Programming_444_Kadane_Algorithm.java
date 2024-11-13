public class D_Dynamic_Programming_444_Kadane_Algorithm {

    // https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
    int maxSubArraySum(int arr[], int n) {
        int currSum = arr[0];
        int overAllSum = arr[0];
        for (int i = 1; i < n; i++) {
            if (currSum > 0) {
                currSum += arr[i];
            } else {
                currSum = arr[i];
            }
            if (currSum > overAllSum)
                overAllSum = currSum;
        }

        return overAllSum;
    }

}
