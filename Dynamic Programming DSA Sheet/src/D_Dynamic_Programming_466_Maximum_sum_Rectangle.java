//import javafx.scene.transform.Scale;

public class D_Dynamic_Programming_466_Maximum_sum_Rectangle {
    // https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1
    // https://www.youtube.com/watch?v=kKEX4P53MyY&t=500s
    int maximumSumRectangle(int R, int C, int M[][]) {
        int res = Integer.MIN_VALUE;

        for (int k = 0; k < R; k++) {
            int[] temp = new int[C];
            for (int i = k; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    temp[j] += M[i][j];
                }
                res = Math.max(res, kadanes(temp));
            }
        }
        return res;
    }

    int kadanes(int[] arr) {
        int csum = arr[0];
        int osum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (csum >= 0) {
                csum += arr[i];
            } else {
                csum = arr[i];
            }
            osum = Math.max(osum, csum);
        }
        return osum;
    }
}

