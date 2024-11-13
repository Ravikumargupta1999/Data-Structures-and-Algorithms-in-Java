package InterviewQuestion;

public class Video_29_Floor_In_Sorted_Array {
    static int findFloor(long arr[], int n, long x)
    {
        int floor = -1;

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] <= x) {
                floor = mid;
                l = mid + 1;
            } else {
                r = mid-1;
            }
        }
        return floor;

    }

}
