import java.util.ArrayDeque;
import java.util.Queue;
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/stacks/moving-average-from-data-stream-official/ojquestion
// https://www.youtube.com/watch?v=nJ-8tw41NwM&list=PL-Jc9J83PIiE1_SifBEWRsD-fzxrvkja9&index=35
public class Moving_Average_From_Data_Stream {
    public static class MovingAverage {
        private Queue<Integer> q;
        private int size;
        private int sum;

        public MovingAverage(int size) {
            this.size = size;
            q = new ArrayDeque<>();
            sum = 0;
        }
        public double next(int val) {
            sum += val;
            q.add(val);
            if (q.size() > size)
                sum -= q.remove();
            double ans = ((double) sum) / q.size();
            return ans;
        }
    }
}
