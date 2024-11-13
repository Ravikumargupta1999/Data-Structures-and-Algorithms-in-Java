public class Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] arr) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+"  "+count);
            if (arr[i] == 0) {
                if (count > ans) {
                    ans = count;
                }
                count = 0;
            } else
                count++;
        }
        if (count > ans)
            ans = count;
        System.out.println(arr.length+"  "+count);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 1};
        System.out.print(findMaxConsecutiveOnes(arr));
    }
}
