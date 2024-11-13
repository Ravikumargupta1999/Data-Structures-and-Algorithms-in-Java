public class Practice_7_Sum_of_two_elements_with_sum_nearest_to_zero {
    // https://practice.geeksforgeeks.org/problems/two-numbers-with-sum-closest-to-zero1737/1?page=14&company[]=Amazon&sortBy=submissions
    // https://www.youtube.com/watch?v=hdOo4AjTc28
    // TC : O(n^2)
    // TC : O(1)
    public static int closestToZero1(int arr[], int n) {
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (i != j) {

                    if (Math.abs(arr[i] + arr[j]) < Math.abs(sum))
                        sum = arr[i] + arr[j];
                }
            }
        }
        return sum;
    }


    // TC : O(n^2)
    // TC : O(1)
    public static int closestToZero(int[] arr, int n) {
        int res = Integer.MAX_VALUE;

        int i = 0;
        int j = n - 1;
        while (i < j) {

            int sum = arr[i] + arr[j];
            if (Math.abs(sum) < Math.abs(res))
                res = sum;

            if (Math.abs(sum) == Math.abs(res))
                res = Math.max(res, res);

            if(sum < 0)
                i++;
            if(sum > 0)
                j--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-8, -66, -60};
        System.out.println(closestToZero(arr, arr.length));
    }
}
