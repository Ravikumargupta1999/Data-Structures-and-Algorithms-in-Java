package Biweekly_Contest_96;

import java.util.HashSet;

public class Problem_1 {
    public int getCommon(int[] nums1, int[] nums2) {
        int res = Integer.MAX_VALUE;
        HashSet<Integer> s1 = new HashSet<>();
        for (int ele : nums1)
            s1.add(ele);

        HashSet<Integer> s2 = new HashSet<>();
        for (int ele : nums2)
            s2.add(ele);

        for (int ele : s1){
            if(s2.contains(ele))
                res = Math.min(res,ele);
        }
        return res == Integer.MAX_VALUE  ? -1 : res;

    }
}
