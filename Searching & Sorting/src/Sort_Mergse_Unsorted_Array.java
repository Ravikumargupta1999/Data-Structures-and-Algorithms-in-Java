// https://practice.geeksforgeeks.org/problems/merging-two-unsorted-arrays-in-sorted-order1020/1/?category[]=Sorting&category[]=Sorting&page=3&query=category[]Sortingpage3category[]Sorting

import java.util.Arrays;

public class Sort_Mergse_Unsorted_Array {
    void sortedMerge(long a[], long b[], long res[], int n,int m)
    {
        Arrays.sort(a);
        Arrays.sort(b);

        // Merge two sorted arrays into res[]
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                res[k] = a[i];
                i += 1;
                k += 1;
            } else {
                res[k] = b[j];
                j += 1;
                k += 1;
            }
        }

        while (i < n) {  // Merging remaining
            // elements of a[] (if any)
            res[k] = a[i];
            i += 1;
            k += 1;
        }
        while (j < m) {   // Merging remaining
            // elements of b[] (if any)
            res[k] = b[j];
            j += 1;
            k += 1;
        }

    }
}
