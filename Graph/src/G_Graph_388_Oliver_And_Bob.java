import java.util.ArrayList;
import java.util.Scanner;

// https://www.youtube.com/watch?v=5h1JYjin_4o
// https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/practice-problems/algorithm/oliver-and-the-game-3/
public class G_Graph_388_Oliver_And_Bob {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        ArrayList<Integer>[] array = new ArrayList[n + 1];
        for (int i = 0; i < array.length; i++)
            array[i] = new ArrayList<>();

        int[] inTime = new int[n + 1];
        int[] outTime = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            inTime[i] = 0;
            outTime[i] = 0;
        }


        for (int i = 0; i < n - 1; i++) {
            int source = s.nextInt();
            int destination = s.nextInt();
            array[source].add(destination);
            array[destination].add(source);
        }
        int timer = 1;
        dfs(1, new boolean[n + 1], array, timer, inTime, outTime);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int type = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            if (!check(x, y, inTime, outTime) && !check(y, x, inTime, outTime)) {
                System.out.println("NO");
                continue;
            }
            if (type == 0) {
                // y subtree of x
                if (check(y, x, inTime, outTime))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            if (type == 1) {
                // x subtree of y
                if (check(x, y, inTime, outTime))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }

    public static int dfs(int src, boolean[] visited, ArrayList<Integer>[] array, int timer, int[] inTime, int[] outTime) {

        visited[src] = true;
        inTime[src] = timer++;
        for (int x : array[src]) {
            if (!visited[x])
                timer = dfs(x, visited, array, timer, inTime, outTime);
        }
        outTime[src] = timer++;
        return timer;
    }

    public static boolean check(int x, int y, int[] inTime, int[] outTime) {
        if (inTime[x] > inTime[y] && outTime[x] < outTime[y])
            return true;
        else
            return false;
    }
}
