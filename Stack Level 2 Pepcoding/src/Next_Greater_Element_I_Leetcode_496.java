import java.util.HashMap;
import java.util.Stack;
//https://leetcode.com/problems/next-greater-element-i/submissions/
public class Next_Greater_Element_I_Leetcode_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] ans = new int[n2];
        ans[n2-1] = -1;
        Stack<Integer> st = new Stack<Integer>();
        st.add(nums2[n2-1]);
        for (int i = n2 - 2; i >= 0; i--) {
            if ( st.size() != 0 && st.peek() > nums2[i]) {
                ans[i] = st.peek();
                st.push(nums2[i]);
            } else {
                while (st.size() != 0 && st.peek() <= nums2[i])
                    st.pop();
                if (st.size() == 0)
                    ans[i] = -1;
                else
                    ans[i] = st.peek();
                st.push(nums2[i]);
            }
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<n2;i++)
        {
            map.put(nums2[i],ans[i]);
        }
        int[] res = new int[n1];
        for(int i=0;i<n1;i++)
        {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
