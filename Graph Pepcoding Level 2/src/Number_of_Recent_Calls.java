import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/number-of-recent-calls/
public class Number_of_Recent_Calls {
    class RecentCounter {
        Queue<Integer> q;
        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.add(t);
            int min = t-3000;
            while (q.size() > 0 && q.peek() < min)
                q.remove();
            return q.size();
        }
    }
}
