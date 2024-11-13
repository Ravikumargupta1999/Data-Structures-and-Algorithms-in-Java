public class Count_Inversions_Another_Solution {
    static long count = 0;

    static long inversionCount(long arr[], long n) {
        mergeSort(arr,0,n-1);
        return count;
    }
    public static long[] merge2SortedArray(long[] left,long[] right)
    {
        long i=0;
        long j = 0;
        long k =0;
        long[] merged = new long[left.length + right.length];
        while (i < left.length && j < right.length)
        {
            if(left[(int) i] <= right[(int)j])
            {
                merged[(int)k] = left[(int)i];
                i++;
                k++;
            }
            else
            {
                count += (left.length-i);
                merged[(int)k] = right[(int)j];
                j++;
                k++;
            }
        }
        while (i < left.length)
        {
            merged[(int) k] = left[(int)i];
            k++;
            i++;
        }
        while ( j < right.length)
        {
            merged[(int)k] = right[(int)j];
            j++;
            k++;
        }
        return merged;
    }
    static long[] mergeSort(long[] arr,long lo,long hi)
    {
        if(lo == hi)
        {
            long[] ba = new long[1];
            ba[(int)0] = arr[(int)lo];
            return ba;
        }
        long mid = (lo + hi)/2;
        long[] left = mergeSort(arr,lo,mid);
        long[] right = mergeSort(arr,mid+1,hi);
        long[] merged = merge2SortedArray(left,right);
        return merged;

    }

    public static void main(String[] args) {
        long[] arr = {8,5,3,4,1,6,2};
        long len = arr.length;

        System.out.println(inversionCount(arr,len));
    }
}
