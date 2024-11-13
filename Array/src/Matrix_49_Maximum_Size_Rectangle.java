
import java.util.Stack;

public class Matrix_49_Maximum_Size_Rectangle {
    // https://www.youtube.com/watch?v=St0Jf_VmG_g
    // https://practice.geeksforgeeks.org/problems/max-rectangle/1
    public static int maxArea(int[][] arr, int n, int m) {
        int[] temp = arr[0];
        int max = LargestAreaHistogram(temp, m);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0)
                    temp[j] = 0;
                else
                    temp[j] = temp[j] + arr[i][j];

            }
            // System.out.println(i + "   " + LargestAreaHistogram(temp, m) + "    " + Arrays.toString(temp));
            max = Math.max(max, LargestAreaHistogram(temp, m));
        }
        return max;
    }

    public static int LargestAreaHistogram(int[] arr, int n) {
        n = arr.length;

        int[] lb = new int[n]; //next smaller element on left2


        int[] rb = new int[n]; //next smaller element on right

        //calculate rb using stack
        Stack<Integer> s = new Stack<>();
        rb[n - 1] = n;
        s.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()])
                s.pop();

            if (s.isEmpty()) {
                s.push(i);
                rb[i] = n;
            } else {
                rb[i] = s.peek();
                s.push(i);
            }
        }

        //Calculate lb using stack
        s = new Stack<>();
        lb[0] = -1;
        s.push(0);

        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()])
                s.pop();

            if (s.isEmpty()) {
                s.push(i);
                lb[i] = -1;
            } else {
                lb[i] = s.peek();
                s.push(i);
            }
        }

        //Calculate maxArea using lb and rb
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * arr[i];

            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] M = {{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};
        System.out.println(maxArea(M, M.length, M[0].length));

    }
}
