import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
// https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
public class Video_11_Count_Unique_Characters_of_All_Substrings_of_a_Given_String {
    public static int uniqueLetterString(String s) {
        int[] dp = new int[s.length() + 1];
        dp[1] = 1;
        for (int i = 2; i < s.length() + 1; i++) {
            dp[i] = dp[i - 1] + i;
        }
        System.out.println(Arrays.toString(dp));
        int ans = 0;
        int total = 0;
        int i = -1;
        int j = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        while (true)
        {
            boolean f1 = false;
            boolean f2 = false;
            while (i < s.length()-1)
            {
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch) == 2)
                    break;
                else {
                    total += (i-j);
                    System.out.println((i-j)+"  "+dp[i-j]);
                    ans += dp[(i - j)];
                }
            }
            while (j < i)
            {
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch) == 1)
                {
                    total += (i-j);
                    System.out.println((i-j)+"  "+dp[i-j]);
                    ans += dp[(i-j)];
                    break;
                }
            }
            if(!f1 && !f2)
                break;
        }
        System.out.println(total);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABA"));
    }

}