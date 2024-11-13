//https://practice.geeksforgeeks.org/problems/jump-game/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=1&page=4&query=category[]Dynamic%20Programmingdifficulty[]1page4category[]Dynamic%20Programming#
//https://leetcode.com/problems/jump-game/submissions/
public class Video_38_Jump_Game {
    // Solution 1 : Real Solution
    int canReach1(int[] arr, int n) {
        if (arr[0] == 0)
            return 0;
        return check(0, arr, n) ? 1 : 0;
    }

    boolean check(int index, int[] arr, int n) {
        if (index == n - 1)
            return true;
        for (int i = 1; i < arr[index]; i++) {
            if (check(index + i, arr, n))
                return true;
        }
        return false;
    }


    // Fake Solution
    boolean canJump(int[] arr) {


        int reachable = 0;

        for (int i = 0; i < arr.length; ++i) {
            if (reachable < i)
                return false;
            reachable = Math.max(reachable, i + arr[i]);
        }
        return true;
    }
}
