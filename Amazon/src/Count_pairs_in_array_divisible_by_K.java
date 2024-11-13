import java.util.HashMap;

public class Count_pairs_in_array_divisible_by_K {
    //https://practice.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1/?category[]=Hash&category[]=Hash&difficulty[]=1&page=2&query=category[]Hashdifficulty[]1page2category[]Hash#

    public static int countKdivPairs(int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(i, 0);
        }
        for (int val : arr) {
            map.put(val % k, map.get(val % k) + 1);
        }
        int sum = 0;
        sum += (map.get(0) * (map.get(0) - 1) / 2);
        for (int i = 1; i <= k / 2 && i != (k - i); i++)
            sum += map.get(i) * map.get(k - i);
        if (k % 2 == 0)
            sum += (map.get(k / 2) * (map.get(k / 2) - 1) / 2);
        return sum;
    }

    static int nCr(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}
