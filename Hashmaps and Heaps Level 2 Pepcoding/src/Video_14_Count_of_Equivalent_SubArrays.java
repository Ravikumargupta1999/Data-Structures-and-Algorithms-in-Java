import java.util.HashMap;
import java.util.HashSet;

public class Video_14_Count_of_Equivalent_SubArrays {
    // Method to calculate distinct sub-array
    // https://practice.geeksforgeeks.org/problems/equivalent-sub-arrays3731/1/
    static int countDistinctSubArray(int arr[], int n) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr) {
            set.add(val);
        }
        int k = set.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < arr.length - 1) {
                f1 = true;
                i++;
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                if (map.size() == k) {
                    ans += (arr.length - i);
                    break;
                }
            }
            while (j < i) {
                f2 = true;
                j++;
                if (map.get(arr[j]) == 1)
                    map.remove(arr[j]);
                else
                    map.put(arr[j], map.getOrDefault(arr[j], 0) - 1);
                if (map.size() == k)
                    ans += arr.length - i;
                else
                    break;
            }
            if (!f1 && !f2)
                break;
        }
        return ans;

    }
}
