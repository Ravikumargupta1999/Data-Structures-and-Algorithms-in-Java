import java.util.ArrayList;
import java.util.List;


// Done
public class Searching_Sorting_108_Majority_Element_II {
    // https://leetcode.com/problems/majority-element-ii/
    // https://www.youtube.com/watch?v=yDbkQd9t2ig
    public List<Integer> majorityElement(int[] arr) {
        int val1 = arr[0];
        int count1 = 1;
        int val2 = arr[0];
        int count2 = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == val1)
                count1++;
            else if (arr[i] == val2)
                count2++;
            else {
                if (count1 == 0) {
                    val1 = arr[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    val2 = arr[i];
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        List<Integer> al = new ArrayList<>();
        if (count1 != 0)
            if (isValid(arr, val1))
                al.add(val1);
        if (count2 != 0)
            if (isValid(arr, val2))
                al.add(val2);
        return al;
    }

    public boolean isValid(int[] arr, int val) {
        int count = 0;
        for (int x : arr)
            if (x == val)
                count++;
        return (count > (arr.length / 3)) ? true : false;

    }
}
