import java.util.Arrays;

public class Array_40_Median_Of_A_Sorted_Array {
    // https://practice.geeksforgeeks.org/problems/find-the-median0527/1
    public int find_fact(int[] v) {
        Arrays.sort(v);
        int median;
        if (v.length % 2 == 0) {
            int value = v[(v.length / 2) - 1] + v[v.length / 2];
            return value / 2;


        } else {
            median = (v.length / 2);
            return v[median];
        }
    }


}
