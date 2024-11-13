public class Sum_Of_Subarray {
    // https://practice.geeksforgeeks.org/problems/sum-of-subarrays2229/1#
    public static long subarraySum(long[] arr, long n) {
//        long mod = 1000000007;
//        long ans =0;
//        long j = n;
//        // code here
//        for(long i=0;i<n;i++)
//        {
//            long temp = arr[(int) i]*(i+1)*(j);
//            j--;
//            ans += temp % mod;
//        }
//        return ans;

        long m = 1000000007;
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            sum = ((arr[i] % m) * ((i + 1) % m) * ((n - i) % m)) % m;
            ans = (ans % m + sum % m) % m;
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = {3, 4, 7, 8, 1};
        System.out.println(subarraySum(arr, arr.length));

    }
}
