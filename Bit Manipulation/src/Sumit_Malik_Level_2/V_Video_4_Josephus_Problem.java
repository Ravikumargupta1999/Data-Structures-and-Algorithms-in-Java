package Sumit_Malik_Level_2;

public class V_Video_4_Josephus_Problem {
    // https://practice.geeksforgeeks.org/problems/josephus-problem/1#
    // https://leetcode.com/problems/find-the-winner-of-the-circular-game/
    public int josephus(int n, int k) {
        return solution(n, k) % (n) + 1;
    }

    // https://www.youtube.com/watch?v=dzYq5VEMZIg
    public static int solution(int n, int k) {
        if (n == 1)
            return 0;
        int x = solution(n - 1, k);
        int y = (x + k) % (n);
        return y;
    }



}
