//https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/1
public class Video_13_Count_Substrings_with_K_Distinct_Characters_Another_Solution {
    long subStrCount(String str, int k) {
        return solve(str, k) - solve(str, k - 1);
    }

    long solve(String s, int k) {
        int n = s.length();
        int j = 0;
        int i = 0;
        long ans = 0;
        int dist_cnt = 0;
        int[] hash_count = new int[26];
        while (j < n) {
            hash_count[s.charAt(j) - 97]++;
            if (hash_count[s.charAt(j) - 97] == 1)
                dist_cnt++;
            while (dist_cnt > k) {
                hash_count[s.charAt(i) - 97]--;
                if (hash_count[s.charAt(i) - 97] == 0)
                    dist_cnt--;
                i++;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }
}
