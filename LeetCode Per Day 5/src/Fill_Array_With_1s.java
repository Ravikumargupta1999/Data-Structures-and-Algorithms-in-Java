import java.util.LinkedList;
import java.util.Queue;

public class Fill_Array_With_1s {
    public long minMoves(long arr[], long n)
    {
        Queue<Long> queue = new LinkedList<>();

        for (long i = 0; i < n; i++) {
            if (arr[(int) i] == 1)
                queue.add(i);
        }

        int moves = -1;

        while (!queue.isEmpty()) {
            long size = queue.size();

            while (size-- > 0) {
                long rem = queue.poll();
                if (rem - 1 >= 0 && arr[(int) (rem - 1)] == 0) {
                    arr[(int) (rem - 1)] = 1;
                    queue.add(rem - 1);
                }
                if (rem + 1 < n && arr[(int) (rem + 1)] == 0) {
                    arr[(int) (rem + 1)] = 1;
                    queue.add(rem + 1);
                }
            }
            moves++;
        }
        return moves;
    }
}
