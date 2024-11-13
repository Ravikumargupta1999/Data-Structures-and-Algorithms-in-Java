import java.util.Arrays;

public class Leetcode_2389_Longest_Subsequence_With_Limited_Sum {
    // https://leetcode.com/contest/weekly-contest-308/problems/longest-subsequence-with-limited-sum/
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            int j = 0;
            int count = 0;
            for (j = 0; j < nums.length; j++) {
                sum += nums[j];
                if(sum <= queries[i])
                    count++;
                else
                    break;
            }
            res[i] = count;
        }
        return res;
    }
}
