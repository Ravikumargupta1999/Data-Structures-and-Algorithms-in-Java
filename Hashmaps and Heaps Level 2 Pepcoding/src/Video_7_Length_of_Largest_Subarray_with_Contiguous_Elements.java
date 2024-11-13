import java.util.HashSet;

public class Video_7_Length_of_Largest_Subarray_with_Contiguous_Elements {
    public static int longest(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int max = arr[i];
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(arr[j]))
                    break;
                set.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if (max - min == j - i)
                    if (j - i + 1 > ans)
                        ans = j - i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        System.out.println(longest(arr));
    }
}
