import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1
public class Video_32_Count_SubArrays_with_equal_1s_and_0s {

    //Function to count subArrays with 1s and 0s.
    static int countSubArrWithEqualZeroAndOne(int[] arr, int n) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                arr[i] = -1;
        }
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                ans += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 0};
        System.out.println(countSubArrWithEqualZeroAndOne(arr, arr.length));
    }
}
