
// Done
public class Array_25_Rearrange_Array_Alternately {
    // Book 1Page 271
    // https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1
    // https://www.youtube.com/watch?v=kQrezgskpho&t=583s
    public static void rearrange(long arr[], int n){
        int max_index = n - 1;
        int min_index = 0;
        long max = arr[n - 1] + 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = (arr[max_index] % max) * max + arr[i];
                max_index--;
            } else {
                arr[i] = (arr[min_index] % max) * max + arr[i];
                min_index++;
            }
        }
        for (int i = 0; i < n; i++)
            arr[i] /= max;

    }

}
