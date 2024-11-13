import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/triplets-with-sum-with-given-range/1/
// https://www.geeksforgeeks.org/count-number-of-triplets-in-an-array-having-sum-in-the-range-a-b/
public class SearchingSorting111_Triplet_In_Range {
    public static int countTripletsLessThan(int []arr, int n, int val)
    {

        Arrays.sort(arr);
        int ans = 0;
        int j, k;
        int sum;
        for (int i = 0; i < n - 2; i++)
        {
            j = i + 1;
            k = n - 1;
            while (j != k)
            {
                sum = arr[i] + arr[j] + arr[k];

                if (sum > val)
                    k--;
                else
                {
                    ans += (k - j);
                    j++;
                }
            }
        }

        return ans;
    }

    public static int countTriplets(int arr[], int n,
                                    int a, int b) {

        int res;
        res = countTripletsLessThan(arr, n, b) -
                countTripletsLessThan(arr, n, a - 1);
        return res;
    }

    public static void main(String[] args) {

    }
}
