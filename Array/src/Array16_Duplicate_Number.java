import java.util.*;

// Done
public class Array16_Duplicate_Number {
    // https://leetcode.com/problems/find-the-duplicate-number/
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i + 1) {
                continue;
            }

            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int next = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = next;
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return nums[i];
        return nums.length;
    }

    // Leet code : Using Extra Space
    public static int FirstRepeat(int[] arr, int n) {
//        int n = arr.length;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hs.put(arr[i], hs.getOrDefault(arr[i], 0) + 1);
        }
        int i = 0;
        for (; i < n; i++) {
            if (hs.get(arr[i]) > 1)
                return arr[i];
        }
        return -1;
    }

    // Will not only if number is repeated one times
    public static int FirstRepeat1(int[] arr, int n) {

        int sum = 0;
        for (int i = 1; i < n; i++)
            sum += i;
        int tsum = 0;
        for (int i = 0; i < n; i++)
            tsum += arr[i];

        for (int i = 0; i < n; i++) {
            if (tsum - arr[i] == sum)
                return arr[i];
        }
        return -1;
    }

    // GFG
    // https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1
    // TC : O(n)
    // SC : O(n)
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (Integer key : map.keySet()) {

            Integer value = map.get(key);
            if (value > 1)
                al.add(key);
        }
        if (al.size() == 0)
            al.add(-1);
        Collections.sort(al);
        return al;
    }

    // GFG
    // https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1
    // TC : O(n)x
    // SC : O(1)
    //      int[] arr = {2,3,1,2,3};
    public static ArrayList<Integer> duplicates1(int arr[], int n) {
        for (int i = 0; i < n; i++) {

            while (arr[i] != i) {

                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
                if (arr[arr[i]] == arr[i])
                    break;
            }

        }
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> al;
        for (int i = 0; i < n; i++) {
            if (arr[i] != i)
                set.add(arr[i]);
        }
        al = new ArrayList<>(set);
        if (al.size() == 0)
            al.add(-1);
        Collections.sort(al);
        return al;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 2};
        System.out.println(duplicates1(arr, arr.length));
    }
}
