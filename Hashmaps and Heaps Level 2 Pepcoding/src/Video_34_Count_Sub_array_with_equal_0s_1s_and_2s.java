import java.util.HashMap;
//https://practice.geeksforgeeks.org/problems/equal-0-1-and-23208/1#
public class Video_34_Count_Sub_array_with_equal_0s_1s_and_2s {
    static long getSubstringWithEqual012(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", 1);
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        long ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                count0++;
            else if (str.charAt(i) == '1')
                count1++;
            else
                count2++;
            String temp = (count1 - count0) + "#" + (count2 - count1);
            if (map.containsKey(temp))
                ans += (map.get(temp));
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "102";
        System.out.println(getSubstringWithEqual012(str));
    }
}
