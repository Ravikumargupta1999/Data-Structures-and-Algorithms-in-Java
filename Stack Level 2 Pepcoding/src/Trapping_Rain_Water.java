import java.util.Stack;

public class Trapping_Rain_Water {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += (Math.min(left[i], right[i]) - arr[i]);
        }
        return count;
    }

    public int trap1(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i=0;i<arr.length;i++)
        {
            while (st.size() >0 && arr[st.peek()] <= arr[i] )
            {
                int rm = i;
                int curr = arr[st.pop()];
                if(st.size() == 0)
                    break;
                int lm = st.peek();
                int width = rm-lm-1;
                ans += (Math.min(arr[lm],arr[rm])-curr)*width;
            }
            st.push(i);
        }
        return ans;

    }
    // O(1) Space
    public int trap2(int[] arr) {
        int l =0;
        int r = arr.length-1;
        int lmax = 0;
        int rmax = 0;
        int ans =0;
        while (l < r)
        {
            lmax = Math.max(lmax,arr[l]);
            rmax = Math.max(rmax,arr[r]);
            if(lmax < rmax)
                ans += (lmax-arr[l++]);
            else
                ans += (rmax-arr[r--]);
        }
        return ans;
    }
}
