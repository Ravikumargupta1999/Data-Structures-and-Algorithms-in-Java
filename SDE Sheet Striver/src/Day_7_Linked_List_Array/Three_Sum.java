package Day_7_Linked_List_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {

    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(i != 0 && arr[i] == arr[i-1])
                continue;
            int si = i + 1;
            int ei = n - 1;
            int temp1 = si;
            int temp2 = ei;
            while (si < ei) {
                int sum = arr[i] + arr[si] + arr[ei];
                if (sum > 0) {
                    ei--;
                } else if (sum < 0) {
                    si++;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(arr[i], arr[si], arr[ei])));
                    si++;
                    ei--;
                    while (si < ei && temp1 != si && arr[si] == arr[si - 1])
                        si++;
                    while (si < ei && temp2 != ei && arr[ei] == arr[ei + 1])
                        ei--;

                }
            }
        }
        return res;

    }
}
