import java.util.HashSet;

public class Video_39_Arithmetic_Sequence {
    // https://practice.geeksforgeeks.org/problems/check-arithmetic-progression1842/1
    public static boolean solution(int[] arr) {
        if (arr.length <= 1)
            return true;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int ele : arr) {
            max = Math.max(ele, max);
            min = Math.min(ele, min);
            set.add(ele);
        }
        int d = (max - min) / (arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            int ai = min + i * d;
            if (!set.contains(ai))
                return false;
        }
        return true;
    }
}
