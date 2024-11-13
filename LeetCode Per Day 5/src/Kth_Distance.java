import java.util.HashMap;

public class Kth_Distance {
    boolean checkDuplicatesWithinK(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int distance = i - map.get(arr[i]);
                if (distance <= k)
                    return true;
            }
            map.put(arr[i], i);


        }
        return false;
    }
}
