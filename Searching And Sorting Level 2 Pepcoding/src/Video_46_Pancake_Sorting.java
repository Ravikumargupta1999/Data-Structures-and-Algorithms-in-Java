import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/pancake-sorting/
public class Video_46_Pancake_Sorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            int maxIdx = i;
            for (int j = i - 1; j >= 0; j--) {
                maxIdx = (arr[maxIdx] < arr[j] ? j : maxIdx);
            }
            if (maxIdx != i) {
                reverse(arr, 0, maxIdx);
                ans.add(maxIdx + 1);
                reverse(arr, 0, i);
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

}
