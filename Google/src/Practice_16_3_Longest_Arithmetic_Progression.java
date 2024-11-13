import java.util.Arrays;
import java.util.HashMap;


public class Practice_16_3_Longest_Arithmetic_Progression {
    // https://practice.geeksforgeeks.org/problems/longest-arithmetic-progression1019/1

    // https://www.youtube.com/watch?v=XjLT4TaXsgw&t=683s

    static int lengthOfLongestAP(int[] arr, int n) {
        HashMap<Integer, Integer>[] maps = new HashMap[n];

        for (int i = 0; i < n; i++)
            maps[i] = new HashMap<>();
        int res = 1;
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                int cd = (arr[i] - arr[j]);

                int length = 2;
                if (maps[j].containsKey(cd))
                    length = maps[j].get(cd) + 1;

                res = Math.max(res, length);
                maps[i].put(cd, length);

            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 10, 13, 14, 19};
        System.out.println(lengthOfLongestAP(arr, arr.length));
    }
}
