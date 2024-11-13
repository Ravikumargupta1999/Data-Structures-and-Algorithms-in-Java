package InterviewQuestion;

public class Video_28_Minimum_Steps_To_Make_Product_Equal_To_One {
    // https://practice.geeksforgeeks.org/problems/minimum-steps-to-make-product-equal-to-one/1
    static int makeProductOne(int[] a, int n) {
        int steps = 0;
        int zeros = 0;
        int negative = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                steps += (a[i] - 1);
            } else if (a[i] == 0) {
                zeros++;
            } else if (a[i] < 0) {
                negative++;
                steps += (-a[i] - 1);
            }
        }
        if (negative % 2 == 0)
            steps += (zeros);
        else {
            if (zeros > 0)
                steps += zeros;
            else
                steps += 2;
        }
        return steps;
    }
}
