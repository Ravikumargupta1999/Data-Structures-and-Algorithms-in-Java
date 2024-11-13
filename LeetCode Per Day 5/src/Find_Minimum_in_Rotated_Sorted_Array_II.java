import java.util.ArrayList;
import java.util.Arrays;

public class Find_Minimum_in_Rotated_Sorted_Array_II {

    public int findMin(int[] nums) {
        int ans = Integer.MIN_VALUE;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums[left] <= nums[mid]) {
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
        }
        return ans;
    }

    public static boolean haveConflict(String[] event1, String[] event2) {
        int n1 = Integer.parseInt(event1[0].substring(0, 2) + event1[0].substring(3));
        int n2 = Integer.parseInt(event1[1].substring(0, 2) + event1[1].substring(3));
        int n3 = Integer.parseInt(event2[0].substring(0, 2) + event2[0].substring(3));
        int n4 = Integer.parseInt(event2[1].substring(0, 2) + event2[1].substring(3));
        System.out.println(n1 + "   " + n2 + "   " + n3 + "   " + n4);
        return (n3 >= n1 && n3 <= n2) || (n4 >= n1 && n4 <= n2) || (n3 <= n1 && n2 <= n4);
    }

    public static long minCost(int[] nums, int[] cost) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new int[]{nums[i], cost[i]};
        }
        Arrays.sort(arr, (a, b) -> {
            return b[1] - a[1];
        });
        long ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (arr[i][0] == arr[0][0])
                continue;
            ans += (Math.abs(arr[i][1] * (Math.abs(arr[0][0] - arr[i][0]))));
        }
        return ans;
    }

    public static int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i; j < nums.length; j++) {
                list.add(nums[j]);
                if (findGCD(list, k))
                    count++;
            }
        }
        return count;
    }

    public static boolean findGCD(ArrayList<Integer> nums, int target) {

        int k = 1000000000, l = 0, i;
        for (i = 0; i <= nums.size() - 1; i++) {
            if (nums.get(i) < k)                   //used to find smallest number
                k = nums.get(i);
            if (nums.get(i) > l)                   //used to find largest number
                l = nums.get(i);
        }
        while (l % k != 0) {
            i = l % k;                          //Euclidean division method to find gcf
            l = k;
            k = i;
        }
        System.out.println(nums + "  " + k);

        return k == target;
    }


    public static void main(String[] args) {
        int[] arr = {3,12,9,6};
        System.out.println(subarrayGCD(arr, 3));
    }
}
