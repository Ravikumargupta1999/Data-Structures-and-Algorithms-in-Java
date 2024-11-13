import java.util.HashMap;

// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
// https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
// https://www.youtube.com/watch?v=BvKv-118twg&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=3
public class Video_3_Check_if_Array_Pairs_are_Divisible_by_K {
    public static boolean canArrange(int[] arr, int k) {
        if (arr.length % 2 != 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            int rem = val % k;
            if (rem < 0)
                val = k + rem;
            if (map.containsKey(val % k)) {
                map.put(val % k, map.get(val % k) + 1);
            } else {
                map.put(val % k, 1);
            }
        }
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                if (map.containsKey(i))
                    if (map.get(i) % 2 != 0) {
                        return false;
                    }
            } else if (i == k - i) {
                if (map.containsKey(i))
                    if (map.get(i) % 2 != 0) {
                        return false;
                    }
            } else {
                if (map.containsKey(i)) {
                    if (map.containsKey(k - i)) {
                        int a = map.get(i);
                        int b = map.get(k - i);
                        if (a != b) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int rem = -2 % 5;
        System.out.println(rem);
        int[] arr = {2, 2, 2, 2, 2, 2};
        int k = 3;
        System.out.println(canArrange(arr, k));
    }
}
