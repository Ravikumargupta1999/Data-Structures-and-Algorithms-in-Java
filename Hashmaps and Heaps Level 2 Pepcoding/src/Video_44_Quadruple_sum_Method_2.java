import java.util.ArrayList;
import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
public class Video_44_Quadruple_sum_Method_2 {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
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
