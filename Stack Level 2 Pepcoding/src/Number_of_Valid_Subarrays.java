import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Stack;

public class Number_of_Valid_Subarrays {
    static int countValidSubarray(int[] arr)
    {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i=arr.length-1;i>=0;i--)
        {
            int val = arr[i];
            while (st.size() >0 && arr[st.peek()] >= val)
                st.pop();
            int si = arr.length;
            if(st.size() > 0)
                si = st.peek();
            ans += (si-i);
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(countValidSubarray(arr));
    }
}
