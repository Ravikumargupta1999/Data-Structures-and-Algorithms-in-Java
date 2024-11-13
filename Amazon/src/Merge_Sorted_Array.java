import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/submissions/

public class Merge_Sorted_Array {
    public static void merge(int[] res, int n, int[] arr2, int m) {
        int[] arr1 = new int[res.length-m];
        for(int i=0;i<n;i++)
        {
            arr1[i] = res[i];
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while(i< n && j < m)
        {
            if(arr1[i] < arr2[j])
            {
                res[k++] = arr1[i++];

            }
            else
            {
                res[k++] = arr2[j++] ;
            }
        }
        while(i < n)
        {
            res[k++] = arr1[i++];

        }
        while(j < m)
        {
            res[k++] = arr2[j++];

        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        int[] arr1 = {1};
        int n = 1;
        int[] arr2 = {};
        int m = 0;
        merge(arr1,n,arr2,m);
    }
}
