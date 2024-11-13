import java.util.Arrays;

// https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
// https://www.youtube.com/watch?v=-z9pFUaUsGQ&t=373s
public class Array_25_Rearrange_The_Array_In_Alternating_Positive_And_Negative_Items {

    public static int[] RearrangeArray(int[] arr, int n) {
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i  < n && arr[i] >= 0)
                i++;
            while (j >=0 && arr[j] < 0)
                j--;
            if( i < j)
                swap(arr,i,j);

        }
        if (i == 0 || i == n) {
            return arr;
        } else {
            int k = 0;
            while (k < n && i < n) {
                swap(arr,k,i);
                k += 2;
                i++;
            }
            return arr;
        }
    }
    public static void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {-5, -2, 5, -2, -4, -7, -1, 8, 0, -8};
        System.out.println(Arrays.toString(RearrangeArray(arr,arr.length)));
    }
}
