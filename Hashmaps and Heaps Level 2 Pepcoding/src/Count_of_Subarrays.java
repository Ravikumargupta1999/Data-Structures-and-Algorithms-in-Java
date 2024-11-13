public class Count_of_Subarrays {
    static long countSubarray(int arr[], int n, int k)
    {
        long s = 0;
        int i = 0;
        long p = 1000000007;
        while (i < n) {
            if (arr[i] > k) {
                i++;
                continue;
            }
            int count = 0;
            while (i < n && arr[i] <= k) {
                i++;
                count++;
            }
            s += ((count * (count + 1)) / 2)%p;
        }
        long a = n * (n + 1) / 2;
        a = a % p;
        return (a - s);
    }
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3 };
        int k = 2;
        int n = arr.length;
        System.out.print(countSubarray(arr, n, k));
    }
}
