public class Reverse_sub_array {
    void reverseSubArray(int arr[], int n, int l, int r) {
        // code here
        l--;
        r--;

        while (l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
