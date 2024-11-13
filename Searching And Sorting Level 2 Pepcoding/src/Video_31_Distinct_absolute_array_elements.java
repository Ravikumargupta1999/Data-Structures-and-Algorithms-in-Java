import java.util.HashSet;

public class Video_31_Distinct_absolute_array_elements {
    //https://practice.geeksforgeeks.org/problems/distinct-absolute-array-elements4529/1
    int distinctCount(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr)
            set.add(Math.abs(val));
        return set.size();
    }

    static int distinctCount1(int[] arr, int n) {
        int count = 0;
        int i = 0;
        int j = n - 1;
        int prev = Integer.MIN_VALUE;
        int next = Integer.MAX_VALUE;
        while (i <= j) {
            if (Math.abs(arr[i]) == Math.abs(arr[j])) {
                if (arr[i] != prev && arr[j] != next) {
                    count++;
                }
                next = arr[j];
                prev = arr[i];
                i++;
                j--;


            } else if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                if (arr[i] != prev)
                    count++;
                prev = arr[i];
                i++;
            } else {
                if (arr[j] != next)
                    count++;
                next = arr[j];
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -2, 0, 3, 4, 5};
        System.out.println(distinctCount1(arr, arr.length));
    }
}
