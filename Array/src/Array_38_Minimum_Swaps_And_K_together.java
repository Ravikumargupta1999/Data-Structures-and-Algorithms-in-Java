public class Array_38_Minimum_Swaps_And_K_together {
//    Done
    // https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1/
    //  https://www.youtube.com/watch?v=6_-zOrJlTDo
    public static int minSwap(int arr[], int n, int k) {
        int good = 0;
        int bad = 0;
        int mi = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                good++;
            }
        }

        for (int i = 0; i < good; i++) {
            if (arr[i] > k) {
                bad++;
            }
        }
        int min = bad;
        int i = 0;

        for (int j = good; j < n;j++){
            if(arr[j] > k)
                bad++;
            if(arr[i] >  k)
                bad--;
            i++;
            min = Math.min(min,bad);
        }
        return min;



    }

}
