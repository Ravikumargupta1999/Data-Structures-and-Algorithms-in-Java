public class Recursion11 {
    //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
    public int numberOfSteps(int num) {
        return totalSteps(num, 0);

    }

    public static int totalSteps(int n, int steps) {

        if (n == 0)
            return steps;
//        System.out.println(n+"  "+steps);
        if (n % 2 == 0)
            return totalSteps(n / 2, steps + 1);
        else
            return totalSteps(n - 1, steps + 1);

    }
}
