import java.util.HashMap;

public class Video_28_Longest_Sub_Array_with_Sum_K {

    // Not all test cases were passed
    public static int lenOfLongSubArr(int[] arr, int N, int target) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
//                System.out.println("If " + i + "   " + (sum - target));
                maxLen = Math.max(maxLen, i - map.get(sum - target));
            } else {
                if (!map.containsKey(sum))
                    map.put(sum, i);
            }
//            System.out.println(map);
        }
        return maxLen;
    }

    // Accepted But understand Solution
    public static int lenOfLongSubarr(int arr[], int n, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;


        for(int i=0;i<n;i++)
        {

            sum +=arr[i];

            if(sum == k )
                maxlen = i+1;
            if(map.containsKey(sum) == false)
                map.put(sum,i);
            if(map.containsKey(sum - k))
                if(maxlen < i - map.get(sum-k))
                    maxlen = i - map.get(sum-k);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int k = 15;
        int[] arr = {-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6};
        k = lenOfLongSubArr(arr, arr.length, k);
        System.out.println(k);
    }
}
