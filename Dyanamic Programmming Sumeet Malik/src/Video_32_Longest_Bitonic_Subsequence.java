//
// https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
// https://www.youtube.com/watch?v=jdfpGSSyN2I

public class Video_32_Longest_Bitonic_Subsequence {
    public static int LongestBitonicSequence(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (lis[j] > max)
                        max = lis[j];
                }
            }
            lis[i] = max + 1;
        }

        int[] lds = new int[n];
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    if (lds[j] > max)
                        max = lds[j];
                }
            }
            lds[i] = max + 1;
        }


        int max = 0;
        for (int i = 0; i < n; i++)
            if ((lds[i] + lis[i] - 1) > max)
                max = (lds[i] + lis[i] - 1);
        return max;
    }

    public static void main(String[] args) {
        int n = 12;
        int[] arr = {20, 7, 9, 6, 9, 21, 12, 3, 12, 16, 1, 27};
        System.out.println(LongestBitonicSequence(arr));

    }
}
