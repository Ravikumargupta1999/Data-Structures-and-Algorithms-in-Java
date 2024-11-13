public class Degree_of_an_Array {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(arr));
    }
    public static int findShortestSubArray(int[] nums) {
        int degree = getDegree(nums,0,nums.length-1);
        System.out.println(degree);
        int res = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int temp = getDegree(nums,i,j);
                if(temp == degree)
                    res = Math.min(res,j-i+1);
            }
        }
        return res;
    }

    static int getDegree(int[] nums, int start, int end) {
        if (start > end)
            return 0;
        int n = nums.length;
        int[] frequencies = new int[50000 + 1];
        for (int i = start; i <= end; i++) {
            int num = nums[i];
            frequencies[num]++;

        }
        int max = 0;
        for (int frequency : frequencies)
            max = Math.max(frequency, max);
        return max;
    }
}
