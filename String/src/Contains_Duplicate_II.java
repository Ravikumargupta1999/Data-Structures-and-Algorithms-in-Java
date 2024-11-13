import java.util.HashMap;
import java.util.HashSet;

public class Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                HashSet<Integer> set = map.get(arr[i]);
                for (int j : set) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
                set.add(i);
                map.put(arr[i], set);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                map.put(arr[i], set);
            }

        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1, 2, 3};
        System.out.println(new Contains_Duplicate_II().containsNearbyDuplicate(arr,2));
    }
}
