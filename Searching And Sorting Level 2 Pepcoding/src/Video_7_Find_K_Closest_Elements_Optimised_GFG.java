import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// https://practice.geeksforgeeks.org/problems/k-closest-elements3619/1#
//Test Cases Passed:
//
//110 / 340
public class Video_7_Find_K_Closest_Elements_Optimised_GFG {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        if (x >= arr[n - 1]) {
            int[] ans = new int[k];
            if (arr[n - 1] == x) {
                int i = 0;
                int j = n - 2;
                while (k-- > 0)
                    ans[i++] = arr[j--];
            } else {
                int i = 0;
                int j = n - 1;
                while (k-- > 0)
                    ans[i++] = arr[j--];
            }
            return ans;
        } else if (x <= arr[0]) {
            int[] ans = new int[k];
            if (x < arr[0]) {
                for (int i = 0; i < k; i++) {
                    ans[i] = arr[i];
                }
            } else {
                int i = 0;
                int j = 1;
                while (k-- > 0) {
                    ans[i++] = arr[j++];
                }
            }
            return ans;
        }
        int s = 0;
        int e = arr.length - 1;
        int mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            if (arr[mid] == x) {
                break;
            } else if (arr[mid] < x)
                s = mid + 1;
            else
                e = mid - 1;
        }

        int l = mid - 1;
        int r = mid;
        if (arr[mid] == x)
            r++;

        // System.out.println(arr[mid]);
        List<Integer> al = new ArrayList<>();
        while (l >= 0 && r < arr.length && k > 0) {
            if (Math.abs(arr[l] - x) < Math.abs(arr[r] - x)) {
                al.add(arr[l]);
                k--;
                l--;
            } else {
                al.add(arr[r]);
                k--;
                r++;
            }
        }
        while (k > 0 && l >= 0) {
            al.add(arr[l]);
            k--;
            l--;
        }
        while (k > 0 && r < arr.length) {
            al.add(arr[r]);
            k--;
            r++;
        }

        int[] ans = new int[al.size()];
        for (int i=0;i<al.size();i++)
            ans[i] = al.get(i);
        return ans;
    }
}
