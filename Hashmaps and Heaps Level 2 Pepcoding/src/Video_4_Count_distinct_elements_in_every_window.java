import java.util.ArrayList;
import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1#
public class Video_4_Count_distinct_elements_in_every_window {
    static ArrayList<Integer> countDistinct(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int val = arr[i];
            if (map.containsKey(val))
                map.put(val, map.get(val) + 1);
            else
                map.put(val, 1);
        }

        ArrayList<Integer> al = new ArrayList<>();
        al.add(map.size());
        int j = 0;
        for (int i = k; i < n; i++) {
            int temp = arr[j++];
            if (map.get(temp) < 2)
                map.remove(temp);
            else
                map.put(temp, map.get(temp) - 1);

            int val = arr[i];

            if (map.containsKey(val))
                map.put(val, map.get(val) + 1);
            else
                map.put(val, 1);
            al.add(map.size());

        }
        return al;
    }
    

    public static void main(String[] args) {
        int[] arr = {4, 1, 1};
        System.out.println(countDistinct(arr, arr.length, 1));
    }
}

//
//The ultimate form of intrinsic motivation is when a habit becomes part of your identity