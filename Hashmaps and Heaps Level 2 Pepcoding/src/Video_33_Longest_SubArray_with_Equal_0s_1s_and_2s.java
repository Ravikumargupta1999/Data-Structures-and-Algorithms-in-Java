import java.util.HashMap;
import java.util.Scanner;

public class Video_33_Longest_SubArray_with_Equal_0s_1s_and_2s {
    public static int solution(int[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                count0++;
            else if (arr[i] == 1)
                count1++;
            else
                count2++;
            String temp = (count1 - count0) + "#" + (count2 - count1);
            if (map.containsKey(temp)) {
                ans = Math.max(ans, i - map.get(temp));
            } else {
                map.put(temp, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
