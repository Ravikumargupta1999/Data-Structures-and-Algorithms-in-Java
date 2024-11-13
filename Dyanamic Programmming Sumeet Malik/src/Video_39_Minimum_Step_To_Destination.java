
// https://leetcode.com/problems/reach-a-number/submissions/
// https://practice.geeksforgeeks.org/problems/minimum-number-of-steps-to-reach-a-given-number5234/1
public class Video_39_Minimum_Step_To_Destination {
    static int minSteps(int D) {
        int step = 0;
        int sum = 0;
        if (D == 0)
            return 0;
        D = Math.abs(D);
        while (sum < D) {
            sum += step;
            step++;
        }
        while ((sum - D) % 2 == 1) {
            sum += step;
            step++;
        }
        return step - 1;
    }
}
