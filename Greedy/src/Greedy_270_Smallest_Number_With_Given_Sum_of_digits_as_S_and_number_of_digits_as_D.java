public class Greedy_270_Smallest_Number_With_Given_Sum_of_digits_as_S_and_number_of_digits_as_D {
    // https://practice.geeksforgeeks.org/problems/smallest-number5829/1/#
    // Time limit exceed
    static String ans = "-1";
    static int min = Integer.MAX_VALUE;

    static String smallestNumber(int S, int D) {
        findSmallest(S, D, 0, 0, 0);
        return ans;
    }

    public static void findSmallest(int S, int totalDigit, int sum, int asf, int digit) {
        System.out.println(S + "  " + totalDigit + "   " + sum + "   " + asf + "   " + digit);
        if (digit == totalDigit) {
            if (S == sum && asf < min) {
                min = asf;
                ans = Integer.toString(asf);
                return;
            }
            return;
        }
        if (digit > totalDigit)
            return;
        for (int i = 0; i <= 9; i++) {
            if (digit == 0 && i == 0) {
                continue;
            } else {
                findSmallest(S, totalDigit, sum + i, asf * 10 + i, digit + 1);
            }
        }

    }
    // https://www.youtube.com/watch?v=H7iqIjbWty4
    // https://practice.geeksforgeeks.org/problems/smallest-number5829/1#

    static String smallestNumber1(int s, int d){
        if (9 * d < s)
            return "-1";
        String ans = "";
        for (int i = d - 1; i >= 0; i--) {
            if (s > 9) {
                ans = "9" + ans;
                s -= 9;
            } else {
                if (i == 0) {
                    ans = (s) + "" + ans;
                }
                else {
                    ans = Integer.toString(s-1) + ans;
                    i--;
                    while (i > 0){
                        ans = "0" + ans;
                        i--;
                    }
                    ans = "1" + ans;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(smallestNumber1(42, 6));
    }
}
