import java.util.*;
//https://practice.geeksforgeeks.org/problems/maximum-intervals-overlap5708/1
//  https://www.youtube.com/watch?v=KifsbWMiGW8
public class Maximum_Intervals_Overlap {
    public int[] findMaxGuests(int[] entry, int exit[], int n) {
        Arrays.sort(entry);
        Arrays.sort(exit);
        int count = 1;
        int ans = 1;
        int i = 1;
        int j = 0;
        int max = entry[0];
        while (i < n && j < n) {
            if (entry[i] <= exit[j]) {
                count++;
                if (count > ans) {
                    ans = count;
                    max = entry[i];
                }
                i++;
            } else {
                count--;
                j++;
            }
        }
        return new int[]{ans, max};
    }
}
