//https://leetcode.com/problems/find-pivot-index/
public class Video_5_Find_Pivot_Index {

    // https://leetcode.com/problems/find-pivot-index/submissions/
    // https://practice.geeksforgeeks.org/problems/equal-sum0810/1/#
    public int pivotIndex(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int leftsum = 0;
        for (int i = 0; i < arr.length; i++) {

            if (sum - arr[i] == leftsum)
                return i;
            sum -= arr[i];
            leftsum += arr[i];
        }
        return -1;
    }
}
