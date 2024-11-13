import java.util.ArrayList;
import java.util.HashMap;



// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class Searching_Sorting_115_5_SubArray_With_Given_Sum {

    static ArrayList<Integer> subArraySum(int[] arr, int n, int target) {
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
