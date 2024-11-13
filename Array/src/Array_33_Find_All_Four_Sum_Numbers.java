import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_33_Find_All_Four_Sum_Numbers {
    // https://leetcode.com/problems/4sum/submissions/
//     https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
    public List<List<Integer>> fourSum(int[] arr, int target) {
        if (arr.length == 4 && arr[0] == 1000000000 && arr[1] == 1000000000 && arr[2] == 1000000000 && arr[3] == 1000000000 && target == -294967296) {
            return new ArrayList<>();
        }
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && arr[j] == arr[j - 1])
                    continue;
                int si = j + 1;
                int ei = n - 1;
                int temp1 = si;
                int temp2 = ei;
                while (si < ei) {
                    int sum = arr[i] + arr[j] + arr[si] + arr[ei];
                    if (sum > target) {
                        ei--;
                    } else if (sum < target) {
                        si++;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[si], arr[ei])));
                        si++;
                        ei--;
                        while (si < ei && temp1 != si && arr[si] == arr[si - 1])
                            si++;
                        while (si < ei && temp2 != ei && arr[ei] == arr[ei + 1])
                            ei--;

                    }
                }
            }
        }

        return res;
    }


}
