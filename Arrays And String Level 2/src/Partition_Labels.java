import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//https://leetcode.com/problems/partition-labels/submissions/
//https://www.youtube.com/watch?v=_I9di3CUOx4&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=10
//https://www.youtube.com/watch?v=_I9di3CUOx4&list=PL-Jc9J83PIiE-TR27GB7V5TBLQRT5RnSl&index=10
public class Partition_Labels {
    public static List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map  = new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),i);
        int prev = -1;
        int max =0;
        List<Integer> al = new ArrayList<>();
        for (int i=0;i<s.length();i++)
        {
            max = Math.max(map.get(s.charAt(i)),max);
            if( max == i) {
                al.add(max - prev);
                prev = max;
            }
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("caedbdedda"));
    }
}
