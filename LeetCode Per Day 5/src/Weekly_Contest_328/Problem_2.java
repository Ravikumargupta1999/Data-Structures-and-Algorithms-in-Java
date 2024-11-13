package Weekly_Contest_328;

public class Problem_2 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];

        for (int[] query : queries) {

            for (int i = query[0]; i <= query[2]; i++) {
                for (int j = query[1]; j <= query[3]; j++) {
                    matrix[i][j] += 1;
                }
            }
        }
        return matrix;
    }
}
