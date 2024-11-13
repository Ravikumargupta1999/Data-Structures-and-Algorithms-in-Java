import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class G_Graph_380_Snake_and_Ladders_Problem {
    // https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1#
    // https://www.youtube.com/watch?v=9SmdrTkEffM&t=1344s
    static int minThrow(int n, int[] arr) {
        int[] mov = new int[31];
        for (int i = 0; i < 2 * n; i += 2) {
            mov[arr[i]] = arr[i + 1];
        }
        boolean[] visited = new boolean[31];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        visited[1] = true;

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int rem = queue.poll();
                if (rem == 30)
                    return step;

                for (int i = 1; i <= 6; i++) {
                    int block = rem + i;
                    if (block > 30)
                        continue;
                    if (!visited[block]) {
                        visited[block] = true;
                        if (mov[block] != 0)
                            queue.add(mov[block]);
                        else
                            queue.add(block);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1#
    // https://www.youtube.com/watch?v=jcMMi4bBeVo
    static int minThrow1(int N, int arr[]) {
        HashMap<Integer, Integer> snake = new HashMap<>();
        HashMap<Integer, Integer> ladders = new HashMap<>();

        for (int i = 0; i < N; i += 2)
            ladders.put(arr[i], arr[i + 1]);


        for (int i = N; i < arr.length; i += 2)
            if (i + 1 < arr.length)
                snake.put(arr[i], arr[i + 1]);

        int moves = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        boolean found = false;

        boolean[] visited = new boolean[31];

        visited[1] = true;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();

            while (size-- > 0) {

                int t = queue.poll();
                for (int die = 1; die <= 6; die++) {
                    if (t + die == 30)
                        found = true;
                    if (t + die <= 30 && ladders.containsKey(t + die) && !visited[ladders.get(t + die)]) {
                        visited[ladders.get(t + die)] = true;
                        if (ladders.get(t + die) == 30)
                            found = true;
                        queue.add(ladders.get(t + die));
                    } else if (t + die <= 30 && snake.containsKey(t + die) && !visited[snake.get(t + die)]) {
                        visited[snake.get(t + die)] = true;
                        if (snake.get(t + die) == 30)
                            found = true;
                        queue.add(snake.get(t + die));
                    } else if (t + die <= 30 && !visited[t + die]) {
                        visited[t + die] = true;
                        queue.add(t + die);
                    }
                }
            }
            moves++;
        }
        return found ? moves : -1;
    }


}
