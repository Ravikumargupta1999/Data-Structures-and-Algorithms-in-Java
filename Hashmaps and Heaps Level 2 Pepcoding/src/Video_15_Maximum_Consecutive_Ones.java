public class Video_15_Maximum_Consecutive_Ones {
    // https://practice.geeksforgeeks.org/problems/maximize-number-of-1s0905/1
    // https://leetcode.com/problems/max-consecutive-ones-iii/
    int findZeroes(int arr[], int n, int m) {
        int j = -1;
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count++;
            while (count > m) {
                j++;
                if (arr[j] == 0)
                    count--;
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }

}
