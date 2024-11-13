import java.util.ArrayList;
import java.util.HashMap;

public class Subarray_with_given_sum {
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(map.get(sum - target) + 2);
                al.add(i + 1);
                return al;
            }
            map.put(sum, i);
        }
        ArrayList<Integer> al = new ArrayList<>();
        al.add(-1);
        return al;

    }
}
