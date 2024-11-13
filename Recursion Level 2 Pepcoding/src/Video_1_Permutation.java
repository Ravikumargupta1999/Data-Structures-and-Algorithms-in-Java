public class Video_1_Permutation {
    public static void main(String[] args) {
        int n = 4;
        int r = 2;
        printPermutation(n, 2, new int[n], 1);
    }

    public static void printPermutation(int n, int r, int[] arr, int val) {
        if (val > r) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = val;
                printPermutation(n, r, arr, val + 1);
                arr[i] = 0;
            }
        }
    }
}
