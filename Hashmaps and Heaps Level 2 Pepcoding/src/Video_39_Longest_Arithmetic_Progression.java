import java.util.HashMap;

public class Video_39_Longest_Arithmetic_Progression {
    static int lengthOfLongestAP(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = arr[i] - arr[j];
                System.out.println(arr[i]+" "+arr[j]+"   "+diff);
                map.put(diff,map.getOrDefault(diff,0)+1);
            }
        }
        int len = 0;
        for (int ele : map.keySet())
            len = Math.max(len,map.get(ele));
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {5,9,10,14};
        System.out.println(lengthOfLongestAP(arr,arr.length));
    }
}
