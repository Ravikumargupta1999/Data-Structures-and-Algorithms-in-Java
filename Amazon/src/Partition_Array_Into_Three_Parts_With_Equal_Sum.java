public class Partition_Array_Into_Three_Parts_With_Equal_Sum {
// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/submissions/

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0)
            return false;
        int left_sum = 0;
        System.out.println(sum);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+left_sum);
            if (arr[i] + left_sum == sum / 3) {
                left_sum = 0;
                count++;
            }
            else {
                left_sum = left_sum + arr[i];
            }
            System.out.println(i+"   "+arr[i] +"  "+ left_sum +"   "+ sum/3);
        }
        if (count == 3)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{0,0,0,0}));
    }
}
