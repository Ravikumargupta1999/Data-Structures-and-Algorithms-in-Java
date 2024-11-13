public class Left_Rotate_Matrix_K_times {
    int[][] rotateMatrix(int N, int M, int k, int Mat[][]) {
        k = k % (M);

        for (int i = 0; i < N; i++) {
            reverse(Mat[i],0,k-1);
            reverse(Mat[i],k,M-1);
            reverse(Mat[i],0,M-1);
        }
        return Mat;
    }

    public void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
