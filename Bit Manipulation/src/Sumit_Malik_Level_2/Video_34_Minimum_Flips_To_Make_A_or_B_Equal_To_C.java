package Sumit_Malik_Level_2;

public class Video_34_Minimum_Flips_To_Make_A_or_B_Equal_To_C {
    // https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/submissions/
    // https://www.youtube.com/watch?v=oLZL8dheuzc&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=34
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            boolean ai = false;
            boolean bi = false;
            boolean ci = false;
            if ((a & (1 << i)) > 0)
                ai = true;
            if ((b & (1 << i)) > 0)
                bi = true;
            if ((c & (1 << i)) > 0)
                ci = true;

            if (ci) {
                if (!ai & !bi) {
                    ans++;
                }
            } else {
                if (ai && bi)
                    ans += 2;
                else if (ai || bi)
                    ans += 1;
            }
        }
        return ans;
    }

}
