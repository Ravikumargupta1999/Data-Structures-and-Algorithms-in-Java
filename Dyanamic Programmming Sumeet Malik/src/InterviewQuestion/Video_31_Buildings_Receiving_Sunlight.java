package InterviewQuestion;

public class Video_31_Buildings_Receiving_Sunlight {
//    https://practice.geeksforgeeks.org/problems/buildings-receiving-sunlight3032/1
    public static int longest(int[] arr, int n) {
        int count = 1;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] >= max)
                count++;
            max = Math.max(arr[i], max);
        }
        return count;
    }
}
