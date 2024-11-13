package InterviewQuestion;

public class Video_17_Index_Of_An_Exra_Element {
    public int findExtra(int a[], int b[], int n) {
        int index = n-1;
        int left = 0;
        int right = n - 2;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (b[mid] == a[mid]) {
                left = mid + 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }
}
