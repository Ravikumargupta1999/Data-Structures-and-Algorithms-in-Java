import java.util.HashMap;
//https://leetcode.com/problems/rabbits-in-forest/
public class Video_37_Rabbits_in_Forest {

    public static int numRabbits(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] + 1)) {
                if (map.get(arr[i] + 1) != arr[i] + 1) {
                    map.put(arr[i] + 1, map.get(arr[i] + 1) + 1);
                } else {
                    ans += map.get(arr[i] + 1);
                    map.put(arr[i] + 1, 1);
                }
            } else {
                map.put(arr[i] + 1, 1);
            }

        }
        for (int val : map.keySet())
            ans += val;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 10, 0};
        System.out.println(numRabbits(arr));
    }
}
