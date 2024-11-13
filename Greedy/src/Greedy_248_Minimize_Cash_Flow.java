public class Greedy_248_Minimize_Cash_Flow {

    public static int minimum(int[] arr, int n) {
        int idx = 0;
        int m = 1000000002;

        for (int i = 0; i < n; i++) {
            if (arr[i] < m) {
                m = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    public static int maximum(int[] arr, int n) {
        int idx = 0;
        int m = -1000000002;

        for (int i = 0; i < n; i++) {
            if (arr[i] > m) {
                m = arr[i];
                idx = i;
            }
        }
        return idx;
    }

    public static int[][] minCashFlow(int[][] transaction, int n) {
        // Net amount of Every friend
        int[] netAmount = new int[n];

        // Fill the amount vector
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                netAmount[i] += (transaction[j][i] - transaction[i][j]);
            }
        }

        // To store total '0' in 'netAmount' vector
        int numberOfZero = 0;

        for (int i = 0; i < n; i++) {
            if (netAmount[i] == 0) {
                numberOfZero += 1;
            }
        }

        // 2-D vector to store answer
        int[][] answer = new int[n][n];

        // Iterate the step until all the element of vector is not '0'
        while (numberOfZero != n) {
            int minAmountIdx = minimum(netAmount, n);
            int maxAmountIdx = maximum(netAmount, n);

            // Reciever has more amount than sender
            if (netAmount[maxAmountIdx] > Math.abs(netAmount[minAmountIdx])) {
                answer[minAmountIdx][maxAmountIdx] = Math.abs(netAmount[minAmountIdx]);
                netAmount[maxAmountIdx] = netAmount[maxAmountIdx] - Math.abs(netAmount[minAmountIdx]);
                netAmount[minAmountIdx] = 0;
            }
            // Reciever has less amount than sender
            else if (netAmount[maxAmountIdx] < Math.abs(netAmount[minAmountIdx])) {
                answer[minAmountIdx][maxAmountIdx] = netAmount[maxAmountIdx];
                netAmount[minAmountIdx] = netAmount[minAmountIdx] + netAmount[maxAmountIdx];
                netAmount[maxAmountIdx] = 0;
            }
            // Reciever has equal amount compare to sender
            else {
                answer[minAmountIdx][maxAmountIdx] = Math.abs(netAmount[minAmountIdx]);
                netAmount[maxAmountIdx] = 0;
                netAmount[minAmountIdx] = 0;
                numberOfZero += 1;
            }

            numberOfZero += 1;
        }

        return answer;
    }
}
