package Day_14_Stack_And_Queue_Part_II;

import java.util.Arrays;
import java.util.Stack;

public class Maximum_Of_Minimum_For_Every_Window_Size {
    static int[] maxOfMin(int[] arr, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = maxOfMinOfWindow(arr, i + 1, n);
        }
        return res;
    }

    static int maxOfMinOfWindow(int[] arr, int k, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                min = Math.min(min,arr[j]);
            }
            max = Math.max(max,min);
        }
        return max;
    }
    static int[] maxOfMin1(int[] arr, int n)
    {
        Stack<Integer> s = new Stack<>();
        int left[] = new int[n+1];
        int right[]  = new int[n+1];
        Arrays.fill(left,-1);
        Arrays.fill(right,n);
        for (int i=0; i<n; i++)
        {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();
            if (!s.empty())
                left[i] = s.peek();
            s.push(i);
        }
        while (!s.empty())
            s.pop();
        for (int i = n-1 ; i>=0 ; i-- )
        {
            while (!s.empty() && arr[s.peek()] >= arr[i])
                s.pop();

            if(!s.empty())
                right[i] = s.peek();

            s.push(i);
        }
        int ans[] = new int[n+1];

        for (int i=0; i<n; i++)
        {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        for (int i=n-1; i>=1; i--)
            ans[i] = Math.max(ans[i], ans[i+1]);
        int[] result = new int[n];
        for (int i=0; i<n; i++)
            result[i] =  ans[i+1];

        return result;
    }
}
