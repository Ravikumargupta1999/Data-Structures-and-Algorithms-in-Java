import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class No_Adjacent_Equal {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2,2,4,4};
        System.out.println(minDeletion(arr));
    }

    static int minOperations(int[] arr) {
        int i = -1;
        int count = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j - 1] == arr[j]) {
                arr[j] = i--;
                count++;
            }
        }
        return count;
    }

    static int minDeletion(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int count = 0;
        for (Map.Entry mapElement : map.entrySet()) {
            int key = (int) mapElement.getKey();
            int value = (int) mapElement.getValue();
            if (value % 2 != 0)
                count++;

        }
        return count;
    }
}