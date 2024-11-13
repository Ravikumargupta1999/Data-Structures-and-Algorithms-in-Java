public class Video_39_Missing_Element_of_AP {
    // https://practice.geeksforgeeks.org/problems/missing-element-of-ap2228/1
    int findMissing(int[] arr, int n) {
        int diff = (arr[n - 1] - arr[0]) / n;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] != arr[i] + diff) {
                return arr[i] + diff;
            }
        }
        return 0;
    }
}
