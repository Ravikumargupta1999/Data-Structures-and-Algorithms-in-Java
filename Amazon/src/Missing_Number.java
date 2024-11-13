// https://practice.geeksforgeeks.org/problems/missing-number4257/1
// https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
public class Missing_Number {
    public static int missingNumber(int arr[], int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += (i);
        int arr_sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr_sum = arr_sum + arr[i];
        }
        for(int i=1 ; i<=n;i++)
        {
            if(sum - i == arr_sum)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
