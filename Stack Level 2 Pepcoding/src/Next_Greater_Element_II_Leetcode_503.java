import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/next-greater-element-ii/submissions/
public class Next_Greater_Element_II_Leetcode_503 {
    public static int[] nextGreaterElements(int[] arr) {
        if( arr.length == 1)
            return new int[]{-1};
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i= n-2;i>=0;i--)
            st.push(arr[i]);
        for(int i=n-1;i>=0;i--)
        {
            if(st.peek() > arr[i])
            {
                ans[i] = st.peek();
                st.push(arr[i]);
            }
            else
            {
                while (st.size() != 0 && st.peek() <= arr[i])
                {
                    st.pop();
                }
                if (st.size() == 0)
                    ans[i] = -1;
                else
                    ans[i] = st.peek();
                st.push(arr[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
}
