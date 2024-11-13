import java.util.Stack;

public class S_Stack_Queue_312_Largest_Area_Rectangle {
    public static int LargestArea(int[][] arr, int n, int m) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = arr[0][i];
        }
        int max = LargestAreaHistogram(temp, m);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0)
                    temp[j] = 0;
                else
                    temp[j] = temp[j] + arr[i][j];

            }
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

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * arr[i];
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;

    }


}
