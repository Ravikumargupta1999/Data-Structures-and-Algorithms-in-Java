public class D_Dynamic_Programming_437_Maximum_difference_of_zeros_and_ones_in_binary_string {
    // https://practice.geeksforgeeks.org/problems/maximum-difference-of-zeros-and-ones-in-binary-string4111/1
    // https://www.youtube.com/watch?v=_k_Codwq1ls
    public static int maxSubstring(String str) {
        int currSum = 0;
        int result = 0;

        for (char ch : str.toCharArray()) {
            int val = ch == '0' ? 1 : -1;

            if (currSum >= 0) {
                currSum += val;
            } else {
                currSum = val;
            }
            result = Math.max(result, currSum);
        }
        return result == 0 ? -1 : result;
    }

    public static void main(String[] args) {
        System.out.println(maxSubstring("11000010001"));
    }
}
