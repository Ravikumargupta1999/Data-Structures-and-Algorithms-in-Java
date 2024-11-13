import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_33_Triplet_That_Sum_To_A_Given_Value {

    // https://leetcode.com/problems/3sum/submissions/
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int k = 0;
        while (k < arr.length) {
            int i = k + 1;
            int j = arr.length - 1;
            int target = -arr[k];
            while (i < j) {
                if (arr[i] + arr[j] == target) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[k]);
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    ans.add(temp);
                    i++;
                    while (i < j && arr[i] == arr[i - 1])
                        i++;
                    j--;
                    while (j >= i && arr[j] == arr[j + 1])
                        j--;
                } else if (arr[i] + arr[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            k++;
            while (k < arr.length && arr[k] == arr[k - 1])
                k++;
        }
        return ans;
    }
    // https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1#
    public static boolean find3Numbers(int[] arr, int n, int target) {
        Arrays.sort(arr);
        for (int i = 0; i < n- 2; i++) {
            int j = i + 1;
            int k = n - 1;
            int sum = target - arr[i];
            while (j < k) {
                if (arr[j] + arr[k] == sum)
                    return true;
                if (arr[j] + arr[k] < sum) {
                    j++;
                } else
                    k--;
            }
        }

        return false;

    }
    // https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1#
    public static boolean find3Numbers(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> allTriplet = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int sum = target - arr[i];
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                int t = arr[start] + arr[end];
                if (t == sum) {
                    allTriplet.add(Arrays.asList(arr[start], arr[end], arr[i]));
                    start++;
                    end--;
                } else if (t < sum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        if (allTriplet.size() == 0)
            return false;
        else
            return true;
    }

}
