import java.util.ArrayList;


public class Searching_Sorting_102_Value_Equal_To_Index {
    // https://practice.geeksforgeeks.org/problems/value-equal-to-index-value1330/1
    public static ArrayList<Integer> valueEqualToIndex(int[] arr, int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == i + 1)
                al.add(i + 1);
        }
        return al;
    }

}
