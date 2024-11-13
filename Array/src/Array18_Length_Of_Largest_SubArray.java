public class Array18_Length_Of_Largest_SubArray {
    // https://www.geeksforgeeks.org/size-subarray-maximum-sum/
    public static int maxSubArraySum(int[] arr, int n) {
        int cSum = arr[0];
        int oSum = arr[0];
        int start = 0;
        int newStart = 0;
        int end = 0;
        for (int i = 1; i < n; i++) {
            if (cSum > 0) {
                cSum += arr[i];
            } else {
                newStart = i;
                cSum = arr[i];
            }
            if (cSum > oSum) {
                oSum = cSum;
                start = newStart;
                end = i;
            }
        }
        for (int i=start;i<= end;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.print("\n");
        return oSum;
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.length;
        System.out.println(maxSubArraySum(a, n));

    }
}
