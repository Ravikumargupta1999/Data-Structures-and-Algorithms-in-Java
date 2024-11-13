import java.util.Arrays;
import java.util.*;



public class Video_39_Largest_Number {
    //https://leetcode.com/problems/largest-number/
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
        }
        Arrays.sort(arr, (a, b) -> {
            long n1 = Long.parseLong(a + b);
            long n2 = Long.parseLong(b + a);
            if (n1 > n2)
                return 1;
            else if (n1 < n2)
                return -1;
            else
                return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--)
            sb.append(arr[i]);
        for (int i = 0; i < sb.length(); i++)
            if (sb.charAt(i) != '0')
                return sb.substring(i);
        return "0";
    }
    // https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1#
    String printLargest(String[] str) {
        ArrayList<String> arr = new ArrayList<>();
        for(String st : str)
            arr.add(st);
        Collections.sort(arr, new Comparator<String>()
        {
            @Override public int compare(String X, String Y)
            {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        Iterator it = arr.iterator();
        String result = "";
        while (it.hasNext())
            result = result +it.next();
        return result;
    }
}
