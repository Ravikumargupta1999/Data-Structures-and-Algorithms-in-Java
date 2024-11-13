public class Video_11_Count_Inversions {
//    static long count = 0;
//
//    static long inversionCount(long arr[], long n) {
//        mergeSort(arr, 0, n);
//        return count;
//    }
//
//    // https://practice.geeksforgeeks.org/problems/merge-sort/1
//    static void mergeSort(long arr[], long l, long r) {
//        MergeSort(arr);
//    }
//
//    public static void MergeSort(long[] A) {
//        long n = A.length;
//        if (n < 2)
//            return;
//        long mid = n / 2;
//        long[] left = new long[(int) mid];
//        long[] right = new long[(int) (n - mid)];
//        for (long i = 0; i < mid; i++) {
//            left[(int) i] = A[(int) i];
//        }
//        for (long i = mid; i < n; i++) {
//            right[(int) (i - mid)] = A[(int) i];
//        }
//        MergeSort(left);
//        MergeSort(right);
//        Merge(left, right, A);
//    }
//
//    public static void Merge(long[] L, long[] R, long[] A) {
//        long nL = L.length;
//        long nR = R.length;
//        long i = 0;
//        long j = 0;
//        long k = 0;
//        while (i < nL && j < nR) {
//            if (L[(int) i] <= R[(int) j]) {
//                A[(int) k] = L[(int) i];
//                i += 1;
//            } else {
//                count += (L.length - i);
//                A[(int) k] = R[(int) j];
//                j += 1;
//            }
//            k += 1;
//        }
//        while (i < nL) {
//            A[(int) k] = L[(int) i];
//            i += 1;
//            k += 1;
//        }
//        while (j < nR) {
//            A[(int) k] = R[(int) j];
//            j += 1;
//            k += 1;
//        }
//
//    }
//
//    public static void main(String[] args) {
//        long[] arr = {8, 5, 3, 4, 1, 6, 2};
//        long len = arr.length;
//
//        System.out.println(inversionCount(arr, len));
//    }
//}
//class hello{
//    static long inversionCount(long arr[], long N)
//    {
//        long temp[] = new long[(int)N];
//        return mergeSort(arr,temp,0,N-1);
//    }
//    static long mergeSort(long arr[],long temp[], long left, long right){
//        long count = 0;
//        long mid;
//        if(left < right){
//            mid = (left+right)/2;
//            count += mergeSort(arr,temp,left,mid);
//            count += mergeSort(arr,temp,mid+1,right);
//
//            count += merge(arr,temp,left,mid+1,right);
//        }
//        return count;
//    }
//    static long merge(long arr[],long temp[],long left, long mid, long right){
//        long i = left;
//        long j = mid;
//        long k = left;
//        long count = 0;
//        while(i <= mid-1 && j <= right){
//            if(arr[(int)i] <= arr[(int)j]){
//                temp[(int)k++] = arr[(int)i++];
//            }
//            else{
//                temp[(int)k++] = arr[(int)j++];
//                count += mid-i;
//            }
//        }
//        while(i <= mid-1){
//            temp[(int)k++] = arr[(int)i++];
//        }
//        while(j <= right){
//            temp[(int)k++] = arr[(int)j++];
//        }
//        for(i = left; i <= right; i++){
//            arr[(int)i] = temp[(int)i];
//        }
//        return count;
//    }

    static long count = 0;
    static long inversionCount(long[] arr, long n) {
        mergeSort(arr, 0, n - 1);
        return count;
    }

    static long[] mergeSort(long[] arr, long lo, long hi) {
        if (lo == hi) {
            long[] a = new long[1];
            a[0] = arr[(int) lo];
            return a;
        }
        long mid = (lo + hi) / 2;
        long[] left = mergeSort(arr, lo, mid);
        long[] right = mergeSort(arr, mid + 1, hi);
        long[] merged = merge2SortedArray(left, right);
        return merged;
    }

    public static long[] merge2SortedArray(long[] left, long[] right) {
        long i=0;
        long j=0;
        long k=0;
        long[] merged = new long[left.length + right.length];
        while (i < left.length && j < right.length){
            if(left[(int) i] <= right[(int) j]){
                merged[(int) k] = left[(int) i];
                i++;
                k++;
            }
            else {
                count += (left.length -i);
                merged[(int) k] = right[(int) j];
                k++;
                j++;
            }
        }
        while (j < right.length){
            merged[(int) k] = right[(int) j];
            k++;
            j++;
        }
        while (i < left.length){
            merged[(int) k] = left[(int) i];
            i++;
            k++;
        }
        return merged;

    }

    public static void main(String[] args) {
        String str =  "49 130 124 85 455 257 341 467 377 432 309 445 440 127 324 38 39 119 83 430 42 334 116 140 159 205 431 478 307 174 387 22 246 425 73 271 330 278 74 98 13 487 291 162 137 356 268 156 75 32 53 351 151 442 225 467 431 108 192 8 338 458 288 254 384 446 410 210 259 222 89 423 447 7 31 414 169 401 92 263 156 411 360 125 38 49 484 96 42 103 351 292 337 375";
        String[] strings = str.split(" ");
        long[] arr = new long[strings.length];
        for (long i = 0; i < arr.length; i++) {
            arr[(int) i] = Long.parseLong(strings[(int) i]);
        }
        int c = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i])
                    c++;
            }
        }
        System.out.println(c);
        System.out.println(inversionCount(arr,arr.length));
    }
}
