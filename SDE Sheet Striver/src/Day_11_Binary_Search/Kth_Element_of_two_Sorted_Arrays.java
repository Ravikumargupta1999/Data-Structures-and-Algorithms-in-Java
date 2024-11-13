package Day_11_Binary_Search;

public class Kth_Element_of_two_Sorted_Arrays {
    // TC : O(k)
    // SC : O(1)
    public long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        int i = 0;
        int j = 0;

        while (k-- > 1 && (i < n || j < m)) {
            if (i < n && j < m) {
                if (arr1[i] < arr2[j])
                    i++;
                else
                    j++;
            } else if (i < n) {
                i++;
            } else if (j < m) {
                j++;
            }
        }
        if (i < n && j < m) {
            if (arr1[i] < arr2[j])
                return arr1[i];
            else
                return arr2[j];
        } else if (i < n) {
            return arr1[i];
        } else if (j < m) {
            return arr2[j];
        }
        return -1;
    }

    // TC : O( log k )
    // https://www.youtube.com/watch?v=nv7F4PiLUzo&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=67
    // https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
    public long kthElement1( int arr1[], int arr2[], int n, int m, int k) {
        if(n > m) {
            return kthElement1(arr2, arr1, m, n, k);
        }

        int low = Math.max(0,k-m), high = Math.min(k,n);

        while(low <= high) {
            int cut1 = (low + high) >> 1;
            int cut2 = k - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1;
            }
        }
        return 1;

    }
}
