import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Video_21_Find_Anagrams_Mappings {
    static class Pair {
        int idx = 0;
        ArrayList<Integer> al = new ArrayList<>();
    }

    static int[] findMapping(int[] arr1, int[] arr2) {
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                Pair p = map.get(arr2[i]);
                p.al.add(i);
            } else {
                Pair p = new Pair();
                p.al.add(i);
                map.put(arr2[i], p);
            }
        }
        int[] ans = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            Pair p = map.get(arr1[i]);
            ans[i] = p.al.get(p.idx);
            p.idx++;
        }
        return ans;
    }

    public static void main(String[] args) {
//        6
//        1 2 3 4 5 2
//        4 3 2 1 5 2
        int[] arr1 = {1, 2, 3, 4, 5, 2};
        int[] arr2 = {4, 3, 2, 1, 5, 2};
        System.out.println(Arrays.toString(findMapping(arr1, arr2)));
    }
}
