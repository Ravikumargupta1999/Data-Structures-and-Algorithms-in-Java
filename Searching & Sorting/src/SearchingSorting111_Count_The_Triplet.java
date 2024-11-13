// https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
// https://www.geeksforgeeks.org/count-triplets-such-that-one-of-the-numbers-can-be-written-as-sum-of-the-other-two/

import java.util.Arrays;

public class SearchingSorting111_Count_The_Triplet {
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int ans = 0;
        int j, k;
        int sum;

        // Fix the first element
        for (int i = 0; i < n - 2; i++)
        {
            j = i + 1;
            k = n - 1;
            while (j != k)
            {
                sum = arr[i] + arr[j] + arr[k];
//                if (sum > val)
//                    k--;
//                else
//                {
//                    ans += (k - j);
//                    j++;
//                }
            }
        }

        return ans;
    }
}
