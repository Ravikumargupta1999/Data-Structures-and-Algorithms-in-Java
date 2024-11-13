public class Index_Of_An_Extra_Element {
    public int findExtra(int a[], int b[], int n) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == b[mid])
                low = mid + 1;
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

}
