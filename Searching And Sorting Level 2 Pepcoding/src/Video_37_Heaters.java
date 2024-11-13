import java.util.Arrays;

// https://leetcode.com/problems/heaters/
public class Video_37_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        for (int val : houses) {
            int ceil = ceilingNumber(heaters, val);
            int floor = floorNumber(heaters, val);
            int temp = 0;
            System.out.println(val + "    " + ceil + "  " + floor);
            if (ceil != -1 && floor != -1)
                temp = Math.min(Math.abs(val - ceil), Math.abs(val - floor));
            else if (ceil == -1)
                temp = Math.abs(val - floor);
            else if (floor == -1)
                temp = Math.abs(val - ceil);
            ans = Math.max(ans, temp);
        }
        return ans;

    }

    public int ceilingNumber(int[] arr, int target) {
        if (arr[arr.length - 1] < target)
            return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid])
                end = mid - 1;

            else if (target > arr[mid])
                start = mid + 1;

            else
                return arr[mid];
        }
        return arr[start];
    }

    public int floorNumber(int[] arr, int target) {
        if (arr[0] > target)
            return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid])
                end = mid - 1;

            else if (target > arr[mid])
                start = mid + 1;

            else
                return arr[mid];
        }
        return arr[end];
    }

    public static void main(String[] args) {
        int[] houses = {3, 8, 2, 4, 11};
        int[] heaters = {1, 8, 5};
        Video_37_Heaters a = new Video_37_Heaters();
        System.out.println(a.findRadius(houses, heaters));
    }
}
