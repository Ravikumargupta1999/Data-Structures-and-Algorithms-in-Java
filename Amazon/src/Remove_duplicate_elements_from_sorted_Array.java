public class Remove_duplicate_elements_from_sorted_Array {
    //https://practice.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1
    //https://www.youtube.com/watch?v=Fm_p9lJ4Z_8
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    static int remove_duplicate(int[] arr, int n) {
        if(n == 1)
            return 1;
        int i = 0;
        int j = 1;
        while (j<= arr.length-1)
        {
            if(arr[i] == arr[j]) {
                j++;
                continue;
            }
            else
            {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,3,3,3,4};
        int len = remove_duplicate(arr,7);
        for(int i=0;i<=len;i++)
            System.out.print(arr[i]+"  ");
        System.out.println("");
    }
}
