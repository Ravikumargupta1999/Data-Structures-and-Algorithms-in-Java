import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/maximum-sum-difference2545/1#

public class Greedy_255_Maximum_Sum_Difference {
    static int maxSum1(int n) {
        if (n == 1)
            return 1;

        return (n * (n - 1) / 2) - 1 + n / 2;
    }

    static int maxSum(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            al.add(i + 1);
            al.add(n - i);
        }
        if (n % 2 != 0) {
            al.add(n / 2 + 1);
        }
        System.out.println("");
        for (int i = 0; i < n; i++) {
            System.out.print(al.get(i) + "  ");
        }
        System.out.println("");
        System.out.println("");
        int max_sum = 0;
        for (int i = 0; i < n - 1; ++i) {
            max_sum = max_sum + Math.abs(al.get(i) - al.get(i + 1));
        }
        return max_sum;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(7));

    }
}
