import java.util.Arrays;
import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1#

public class Searching_Sorting_107_First_Missing_And_Repeating_Number {
    // TC : O(n)
    // SC : O(n)
    public static int[] findTwoElement1(int[] arr, int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (hashMap.get(arr[i]) > 1)
                ans[0] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(i + 1))
                ans[1] = i + 1;
        }
        return ans;
    }

    // TC : O(n)
    // SC : O(1)
    // Cyclic Sort
    public static int[] findTwoElement2(int[] arr, int n) {
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            while (arr[i] != i + 1 && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        int i = 0;
        while (i < n) {
            if (arr[i] != i + 1) {
                res[0] = arr[i];
                res[1] = i + 1;
            }
            i++;
        }
        return res;
    }

    // TC : O(n)
    // SC : O(1)
    public static int[] findTwoElement3(int[] arr, int n) {
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            System.out.println((arr[i]-1)+"   "+arr[Math.abs(arr[i]) - 1]+"   "+arr[i]);
            if (arr[Math.abs(arr[i]) - 1] < 0) {
                System.out.println("if");
                ans[0] = Math.abs(arr[i]);
            }
            else {
                System.out.println("else");
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
            }
            System.out.println(i+"   "+Arrays.toString(arr)+"    "+Arrays.toString(ans)+"\n");
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans[1] = i + 1;
                break;
            }
        }
        return ans;
    }

    int[] findTwoElement(int arr[], int n) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++)
            xor ^= arr[i];

        for (int i = 1; i <= arr.length; i++)
            xor ^= i;

        int rightMostSetBits = xor & -xor;

        int x = 0;
        int y = 0;
        for (int val : arr)
            if ((val & rightMostSetBits) == 0)
                x = x ^ val;
            else
                y = y ^ val;

        for (int i = 1; i <= arr.length; i++)
            if ((i & rightMostSetBits) == 0)
                x = x ^ i;
            else
                y = y ^ i;

        int[] arr1 = new int[2];
        for (int val : arr)
            if (val == x) {
                arr1[0] = x;
                arr1[1] = y;
            } else if (val == y) {
                arr1[0] = y;
                arr1[1] = x;
            }
        return arr1;
    }

}