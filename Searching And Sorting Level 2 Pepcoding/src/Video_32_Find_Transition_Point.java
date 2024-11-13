public class Video_32_Find_Transition_Point {

    // https://practice.geeksforgeeks.org/problems/find-transition-point-1587115620/1
    int transitionPoint(int arr[], int n) {
        if (arr[0] == 1)
            return 0;
        else if (arr[0] == 0 && arr[n - 1] == 0)
            return -1;
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == 1) {
                ans = mid;
                j = mid - 1;
            } else
                i = mid + 1;
        }
        return ans;
    }
}
