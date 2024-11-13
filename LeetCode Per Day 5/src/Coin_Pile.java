import java.util.Arrays;

public class Coin_Pile {
    static int minSteps(int[] A, int N, int K) {
        // code here
        Arrays.sort(A);
        int i = 0;
        int j = N - 1;
        int count = 0;
        while (true) {
            if(j == -1)
                break;
            if (A[j] - A[i] <= K)
                return count;
            j--;
        }
        return count;

    }
}
