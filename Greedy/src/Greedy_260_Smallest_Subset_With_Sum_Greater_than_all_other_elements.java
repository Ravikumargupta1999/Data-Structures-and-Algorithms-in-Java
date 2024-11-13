import java.util.Arrays;

public class Greedy_260_Smallest_Subset_With_Sum_Greater_than_all_other_elements {
    // https://www.geeksforgeeks.org/smallest-subset-sum-greater-elements/
    // https://practice.geeksforgeeks.org/problems/smallest-subset-with-greater-sum/1/#

    int minSubset(int[] arr,int n) {

        Arrays.sort(arr);
        long sum = 0;
        for (int val : arr)
            sum += val;
        long subsetSum = 0;
        int length = 0;
        for (int i = n - 1; i >= 0; i--) {
            length++;
            subsetSum += arr[i];
            sum -= arr[i];
            if (subsetSum > sum)
                return length;
        }
        return length;
    }
}
