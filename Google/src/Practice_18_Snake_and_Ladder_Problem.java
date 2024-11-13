import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Practice_18_Snake_and_Ladder_Problem {
    // https://www.youtube.com/watch?v=jcMMi4bBeVo
    // https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1
    static int minThrow(int N, int arr[]) {
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
                        return moves + 1;
                    if (t + die <= 30 && ladders.containsKey(t + die) && !visited[ladders.get(t + die)]) {
                        visited[ladders.get(t + die)] = true;
                        if (ladders.get(t + die) == 30)
                            return moves + 1;
                        queue.add(ladders.get(t + die));
                    } else if (t + die <= 30 && snake.containsKey(t + die) && !visited[snake.get(t + die)]) {
                        visited[snake.get(t + die)] = true;
                        if (snake.get(t + die) == 30)
                            return moves + 1;
                        queue.add(snake.get(t + die));
                    } else if (t + die <= 30 && !visited[t + die]) {
                        visited[t + die] = true;
                        queue.add(t + die);
                    }
                }
            }
            moves++;
        }
        return -1;

    }

    public int snakesAndLadders(int[][] board) {

        HashMap<Integer, Integer> snake = new HashMap<>();
        int n = board.length;
        int k = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] != -1) {
                    snake.put(k, board[i][j]);
                }
                k++;
            }
        }

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
                    if (t + die == n * n)
                        return moves + 1;

                    if (t + die <= n * n && snake.containsKey(t + die) && !visited[snake.get(t + die)]) {
                        visited[snake.get(t + die)] = true;
                        if (snake.get(t + die) == 30)
                            return moves + 1;
                        queue.add(snake.get(t + die));
                    } else if (t + die <= n * n && !visited[t + die]) {
                        visited[t + die] = true;
                        queue.add(t + die);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
