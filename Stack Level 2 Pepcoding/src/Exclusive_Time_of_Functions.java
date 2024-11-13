import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/exclusive-time-of-functions/
public class Exclusive_Time_of_Functions {
    class Pair {
        int id;
        int st;
        int ct;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] timeF = new int[n];
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < logs.size(); i++) {
            String[] temp = logs.get(i).split(":");
            if ("start".equals(temp[1])) {
                Pair p = new Pair();
                p.id = Integer.parseInt(temp[0]);
                p.st = Integer.parseInt(temp[2]);
                p.ct = 0;
                st.push(p);
            } else {
                Pair p = st.pop();
                int interval = Integer.parseInt(temp[2]) - p.st + 1;
                int time = interval - p.ct;
                timeF[p.id] += time;
                if (st.size() > 0)
                    st.peek().ct += interval;
            }
        }
        return timeF;
    }
}
