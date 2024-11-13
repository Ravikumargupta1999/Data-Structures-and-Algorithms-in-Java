package InterviewQuestion;

import java.util.HashSet;

public class Video_53_Consecutive_Array_Elements {
    static boolean areConsecutive(long[] arr, int N) {
        if (N == 1)
            return true;
        long max = arr[0];
        long min = arr[0];
        HashSet<Long> set = new HashSet<>();

        for (long val : arr) {
            set.add(val);
            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        if (set.size() != N)
            return false;

        for (long val : arr) {
            if (max == val) {
                if (!set.contains(max - 1))
                    return false;
            } else if (min == val) {
                if (!set.contains(val + 1))
                    return false;
            } else {
                if (!set.contains(val - 1) || !set.contains(val + 1))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long[] arr = {};
        System.out.println(areConsecutive(arr,arr.length));
    }
}
