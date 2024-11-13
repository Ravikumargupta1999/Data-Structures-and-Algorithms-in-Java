import java.util.HashSet;

public class Find_Unique_Binary_String {
    // https://leetcode.com/problems/find-unique-binary-string/submissions/
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for (String str : nums)
            set.add(str);
        int n = nums[0].length();
        return getAnswer(n, 0, "", set);
    }

    public String getAnswer(int n, int ind, String res, HashSet<String> set) {
        if (ind == n)
            return res;
        String s = getAnswer(n,ind+1,res+"0",set);
        if(!set.contains(s))
            return s;
        return getAnswer(n,ind+1,res+"1",set);
    }
}
