package Sumit_Malik_Level_2;

import java.util.HashMap;
import java.util.Map;

public class Video_12_Element_That_Appears_Once_Where_All_Others_Appear_Thrice {
    // https://www.youtube.com/watch?v=XxKc-YtcGoo&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=12
    // https://leetcode.com/problems/single-number-ii/submissions/
    // https://practice.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1/
    public int singleNumber(int[] arr) {
        int o = 0;
        int t = 0;
        for (int x : arr) {
            int oo = ((~t) & o & (~x)) | ((~t) & (~o) & x);
            int tt = (t & (~o) & (~x)) | ((~t) & o & x);
            o = oo;
            t = tt;
        }
        return o;
    }

    static int singleElement(int[] a, int N) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (!frequencyMap.containsKey(a[i])) frequencyMap.put(a[i], 0);

            frequencyMap.put(a[i], frequencyMap.get(a[i]) + 1);
        }
        for (Map.Entry<Integer, Integer> me : frequencyMap.entrySet()) {
            if (me.getValue() == 1) {
                return me.getKey();
            }
        }
        return -1;
    }
}
