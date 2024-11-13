package Sumit_Malik_Level_2;

import java.util.Arrays;

public class V_Video_1_Find_Pair_Given_Difference {
    // https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    public boolean findPair(int[] arr, int size, int k) {
        int l = 0;
        int r = 0;

        while (l < size) {
            if (l == r) {
                l++;
            }
            int diff = arr[l] - arr[r];

            if (diff == k) {
                return true;
            } else if (diff < k)
                r++;
            else
                l++;
        }
        return false;
    }

    // https://practice.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    public int TotalPairs(int[] arr, int k) {

        Arrays.sort(arr);
        int l = 0;
        int r = 0;

        int n = arr.length;

        int count = 0;

        while (l < n) {
            if (l == r) {
                l++;
            }
            if (l == n)
                break;
            int diff = arr[l] - arr[r];

            if (diff == k) {
                int i = l;
                l++;
                while (l < n && arr[i] == arr[l])
                    l++;
                count++;
            } else if (diff < k)
                l++;
            else
                r++;
        }
        return count;
    }
}
