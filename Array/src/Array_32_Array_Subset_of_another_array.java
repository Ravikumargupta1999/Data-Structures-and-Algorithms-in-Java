import java.util.*;

// https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1#
public class Array_32_Array_Subset_of_another_array {
    public String isSubset(long[] a1, long[] a2, long n, long m) {

        HashSet<Long> set = new HashSet<>();
        for (long v : a1)
            set.add(v);
        for (long v : a2) {
            if (!set.contains(v))
                return "No";
        }
        return "Yes";
    }
}
