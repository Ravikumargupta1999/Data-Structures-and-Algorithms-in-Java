package InterviewQuestion;

public class Video_50_Game_Of_XOR {
    static int gameOfXor(int N, int[] A) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                for (int k = i; k <= j; k++) {
                    res ^= A[k];
                    System.out.print(A[k] + "\t");
                }
                System.out.println("");
            }
            System.out.println("");
        }
        return res;
    }

    static int gameOfXor1(int n, int[] arr) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            int val = (i + 1) * (n - i);  // occurance of this index in all subArray
            if (val % 2 != 0)    // consider this element in resultant subArray only if it occur odd number of times
                res ^= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        gameOfXor(3, new int[]{1, 2, 3});
    }

}
