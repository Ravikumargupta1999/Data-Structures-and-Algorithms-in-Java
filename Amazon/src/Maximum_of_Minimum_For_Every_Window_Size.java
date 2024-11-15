import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1#

public class Maximum_of_Minimum_For_Every_Window_Size {
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n)
    {
        Stack<Integer> s = new Stack<>();
        int left[] = new int[n+1];
        int right[]  = new int[n+1];
        for (int i=0; i<n; i++)
        {
            left[i] = -1;
            right[i] = n;
        }
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
        for (int i=0; i<=n; i++)
            ans[i] = 0;
        for (int i=0; i<n; i++)
        {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        for (int i=n-1; i>=1; i--)
            ans[i] = Math.max(ans[i], ans[i+1]);
        int[] result = new int[n];
        for (int i=1; i<=n; i++)
            result[i-1] =  ans[i];

        return result;
    }
}
