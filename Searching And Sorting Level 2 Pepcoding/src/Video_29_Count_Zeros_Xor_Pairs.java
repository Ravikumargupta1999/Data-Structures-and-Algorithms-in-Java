import java.util.HashMap;

public class Video_29_Count_Zeros_Xor_Pairs {
    // Function for finding maximum and value pair
    // https://practice.geeksforgeeks.org/problems/counts-zeros-xor-pairs0349/1/
    public static long calculate(int[] a, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            if (map.containsKey(a[i]))
                map.put(a[i], map.get(a[i]) + 1);
            else
                map.put(a[i], 1);
        long count = 0;
        for (int val : map.keySet()) {
            int f = map.get(val);
            if (f > 1) {
                count += (((f) * (f - 1)) / 2);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2};
        System.out.println(calculate(arr, arr.length));
    }
}
