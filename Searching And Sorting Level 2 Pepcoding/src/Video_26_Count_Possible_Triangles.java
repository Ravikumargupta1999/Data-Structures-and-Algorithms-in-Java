import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1#
public class Video_26_Count_Possible_Triangles {
    static int findNumberOfTriangles(int arr[], int n) {
        if (n < 3)
            return 0;
        // code here
        Arrays.sort(arr);
        int count = 0;
        for (int i = n - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) {
                    count += (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}
