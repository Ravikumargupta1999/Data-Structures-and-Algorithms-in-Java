import java.util.ArrayList;

public class Video_7_Two_2_Keys_Keyboard {
    // https://leetcode.com/problems/2-keys-keyboard/
    // https://www.youtube.com/watch?v=anHoebBokmg&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG&index=7
    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; ) {
            if (n % i == 0) {
                ans += i;
                n /= i;
            } else
                i++;
        }
        if (n != 1)
            ans += n;
        return ans;
    }

    // Recursion
    int minimumSteps(int n) {
        if (n == 1)
            return 0;

        int copy = 1;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(Integer.MAX_VALUE);
        recursion(2, n, 1, 2, res);
        return res.get(0);
    }

    void recursion(int count, int total, int copy, int operation, ArrayList<Integer> res) {
        if (count > total)
            return;
        if (count == total) {
            res.set(0, Math.min(res.get(0), operation));
            return;
        }
        if (operation > total)
            return;

        recursion(count, total, count, 1 + operation, res);
        // paste
        recursion(count + copy, total, copy, 1 + operation, res);
    }

    public static void main(String[] args) {

    }
}
