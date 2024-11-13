import java.util.Arrays;
import java.util.Stack;

public class Smaller_on_Left {
    // Function for finding maximum and value pair
    public static int[] Smallestonleft(int arr[], int n) {
        Stack<Integer> S = new Stack<>();
        int[] ans = new int[n];
        ans[0] = -1;
        S.push(arr[0]);
        for (int i = 1; i < n; i++) {

            while (!S.empty() && S.peek() >= arr[i]) {
                S.pop();
            }
            if (S.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = S.peek();
            }
            S.push(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 7, 8, 7};
        System.out.println(Arrays.toString(Smallestonleft(arr, arr.length)));
    }
}
