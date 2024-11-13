import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
// https://www.youtube.com/watch?v=20v8zSo2v18
public class Practice_6_Subarray_with_given_sum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int rsum = sum - s;
            if (map.containsKey(rsum)) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(map.get(rsum) + 1 + 1);
                al.add(i + 1);
                return al;
            }
            map.put(sum, i);
        }
        ArrayList<Integer> al = new ArrayList<>();
        al.add(-1);
        return al;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 15));
    }
}
