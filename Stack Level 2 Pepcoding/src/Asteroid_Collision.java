import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
public class Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int val : asteroids) {
            if (val > 0) {
                st.push(val);
            } else {
                while (st.size() > 0 && st.peek() > 0 && st.peek() < -val)
                    st.pop();
                if (st.size() > 0 && st.peek() == -val)
                    st.pop();
                else if (st.size() > 0 && st.peek() > -val) ;
                else
                    st.push(val);
            }
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--)
            ans[i] = st.pop();
        return ans;
    }
}
