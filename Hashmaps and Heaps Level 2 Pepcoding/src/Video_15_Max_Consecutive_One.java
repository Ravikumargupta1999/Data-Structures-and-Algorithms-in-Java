public class Video_15_Max_Consecutive_One {
    //https://leetcode.com/problems/max-consecutive-ones/
    public static int findMaxConsecutiveOnes(int[] arr) {
        if (arr.length == 0)
            return 0;
        int ans = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count > ans)
                    ans = count;
            } else
                count = 0;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
