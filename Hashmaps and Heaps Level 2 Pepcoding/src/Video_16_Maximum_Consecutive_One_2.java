public class Video_16_Maximum_Consecutive_One_2 {
    public static int solution(int[] arr) {
        int n = arr.length;
        int j = -1;
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count++;
            while (count > 1) {
                j++;
                if (arr[j] == 0)
                    count--;
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,1,1,1,1,0};
        System.out.println(solution(arr));
    }
}
