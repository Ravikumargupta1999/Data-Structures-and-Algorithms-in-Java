package Day_7_Linked_List_Array;

public class Remove_Duplicates_from_Sorted_Array {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 2, 4};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 1)
            return 1;
        int i = 0;
        int j = 1;
        while (j <= arr.length - 1) {
            if (arr[i] == arr[j]) {
                j++;
                continue;
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        return i + 1;
    }
}