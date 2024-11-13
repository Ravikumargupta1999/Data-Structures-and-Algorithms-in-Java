import java.util.Arrays;

public class Video_25_Count_the_Triplets {
    // https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
    static int countTriplet(int arr[], int n) {
        if (n < 3)
            return 0;
        Arrays.sort(arr);
        int count = 0;
        for (int i = n - 1; i >= 2; i--) {
            int j = 0;
            int k = i - 1;
            while (j < k) {
                if (arr[j] + arr[k] == arr[i]) {
                    count++;
                    j++;
                    k--;
                } else if (arr[j] + arr[k] < arr[i])
                    j++;
                else
                    k--;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 2};
        System.out.println(countTriplet(arr, arr.length));
    }
}
