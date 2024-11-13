//https://www.youtube.com/watch?v=ju8vrEAsa3Q&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=25
// https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1

import java.util.*;

public class Video_14_Paint_Fench {
    long countWays(int n, int k) {
        if (n == 1)
            return k;
        int p = 1000000007;
        long same = k * 1;
        long different = k * (k - 1);
        long total = same + different;
        for (int i = 3; i <= n; i++) {
            same = (different * 1) % p;
            different = ((total % p) * ((k - 1) % p)) % p;
            total = (same % p + different % p) % p;
        }
        return total;
    }

    static int kthMex(int n, int k, int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int v : arr)
            set.add(v);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (true) {
            if (set.contains(i)) {
                i++;
            } else {
                k--;
                if (k == 0)
                    return i;
                i++;
            }
        }
    }


}
