package InterviewQuestion;

import java.util.HashSet;

public class Video_53_Check_If_Array_Contains_Contiguous_Integers_With_Duplicates_Allowed {
    public static boolean areElementsContiguous(int[] arr, int n) {
        if (n == 1)
            return true;
        int max = arr[0];
        int min = arr[0];
        HashSet<Integer> set = new HashSet<>();

        for (int val : arr) {
            set.add(val);
            max = Math.max(max, val);
            min = Math.min(min, val);
        }


        for (int val : arr) {
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
        int[] arr = {2,3,6,1,5,4};
        System.out.println(areElementsContiguous(arr,arr.length));
    }
}
