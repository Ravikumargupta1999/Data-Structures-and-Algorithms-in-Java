import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// https://leetcode.com/problems/find-all-duplicates-in-an-array/submissions/

public class Find_All_Duplicates_in_an_Array {
    public static List<Integer> findDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr.length + 1)
                continue;
            while (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                if (arr[i] == arr.length + 1 || arr[arr[i] - 1] == arr[i])
                    break;
            }
        }
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != i + 1)
                al.add(arr[i]);
        System.out.println(Arrays.toString(arr));
        return al;

    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{1,}));
    }
}
