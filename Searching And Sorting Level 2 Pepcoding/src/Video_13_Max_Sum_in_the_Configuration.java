// https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
// https://www.youtube.com/watch?v=yroWfS5P2E4&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=13
public class Video_13_Max_Sum_in_the_Configuration {
    static int max_sum(int arr[], int n) {
        int sum = 0;
        int s0 = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            s0 += (i * arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        int si = s0;
        for (int i = 0; i < n; i++) {
            int temp = si + sum - (n * arr[n - 1 - i]);
            ans = Math.max(ans, temp);
            si = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {8,3,1,2};
        System.out.println(max_sum(arr,arr.length));
    }
}
