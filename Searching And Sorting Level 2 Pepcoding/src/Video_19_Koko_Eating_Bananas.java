public class Video_19_Koko_Eating_Bananas {
    // https://leetcode.com/problems/koko-eating-bananas/
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        if( h < piles.length)
            return -1;

        for (int val : piles)
            max = Math.max(max, val);

        if (h == piles.length)
            return max;

        int lo = 1;
        int hi = max;

        int speed = Integer.MAX_VALUE;
        while (lo <= hi) {
            int sp = lo + (hi - lo) / 2;
            if (isPossible(piles, sp, h)) {
                speed = sp;
                hi = sp - 1;
            } else {
                lo = sp + 1;
            }
        }
        return speed;
    }

    public boolean isPossible(int[] piles, int sp, int h) {
        int ans = 0;
        for (int val : piles) {
            if (val % sp == 0)
                ans += (val / sp);
            else
                ans += (val / sp) + 1;
        }
        if (ans <= h)
            return true;
        return false;
    }

}
