import java.util.ArrayList;
import java.util.HashMap;

// https://www.codingninjas.com/codestudio/problems/count-subarrays-with-given-xor_1115652
public class A_Trie_14_Count_SubArrays_with_Given_XOR {
    // Brute Force
    // TC : O(n^2)
    public static int subrraysXor(ArrayList<Integer> arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            int ans = 0;
            for (int j = i; j < arr.size(); j++) {
                ans = ans ^ arr.get(j);
                if (ans == x)
                    count++;
            }
        }
        return count;
    }

    // https://www.youtube.com/watch?v=lO9R5CaGRPY&t=903s
    public static int subArraysXor(ArrayList<Integer> arr, int x) {
        int count = 0;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            xor = xor ^ arr.get(i);
            if (xor == x)
                count++;
            if (map.get(xor ^ x) != null)
                count += map.get(xor ^ x);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}
