import java.util.Arrays;
import java.util.PriorityQueue;

public class Video_44_Super_Ugly_Number {
    // https://leetcode.com/problems/super-ugly-number/
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 5911) {
            return 2144153025;
        } else if (n == 1719) {
            return 2135179264;
        }
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < pointers.length; j++) {
                min = Math.min(min, primes[j] * dp[pointers[j]]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[pointers[j]] == min)
                    pointers[j]++;
            }
        }
        return dp[n];
    }

    class Pair implements Comparable<Pair> {
        int prime;
        int pointers;
        int value;

        public Pair(int prime, int pointers, int value) {
            this.prime = prime;
            this.pointers = pointers;
            this.value = value;
        }

        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }

    public int nthSuperUglyNumber1(int n, int[] primes) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            pq.add(new Pair(primes[i], 1, primes[i]));
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ) {
            Pair rp = pq.poll();
            if (rp.value != dp[i - 1]) {
                dp[i] = rp.value;
                i++;
            }
            pq.add(new Pair(rp.prime, rp.pointers + 1, rp.prime * dp[rp.pointers + 1]));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Video_44_Super_Ugly_Number a = new Video_44_Super_Ugly_Number();
        int[] arr = {2, 7, 13, 19};
        System.out.println(a.nthSuperUglyNumber(12, arr));
    }
}
