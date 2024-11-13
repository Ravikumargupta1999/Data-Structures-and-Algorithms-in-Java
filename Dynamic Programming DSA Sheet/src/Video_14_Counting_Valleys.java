import java.util.Scanner;

public class Video_14_Counting_Valleys {
    // https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=false
    //https://www.youtube.com/watch?v=3QfQJj38gUM
    public static int countingValleys(int steps, String path) {
        int attitude = 0;
        int x = 0;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                if(attitude == -1)
                    x++;
                attitude++;
            } else {
                attitude--;
            }
        }
        return x;

    }

    // https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-valleys-mountains-official/ojquestion#
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int inside = i - 1;
            int outside = 0;
            while (inside >= 0) {
                dp[i] += (dp[inside] * dp[outside]);
                inside--;
                outside++;
            }
        }
        System.out.println(dp[n]);
    }
}
