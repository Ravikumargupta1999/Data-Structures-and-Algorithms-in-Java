import java.util.ArrayList;
import java.util.PriorityQueue;

public class G_Graph_367_Dijkstra_algo {
    // https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1/#
    // https://www.youtube.com/watch?v=sD0lLYlGCJE
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];

        // int[2]  : 0 index --> node  1 index --> weight
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(new int[]{S, 0});
        while (!queue.isEmpty()) {
            int[] rem = queue.poll();
            if (visited[rem[0]])
                continue;
            ans[rem[0]] = rem[1];
            visited[rem[0]] = true;
            for (ArrayList<Integer> arrayList : adj.get(rem[0])) {
                if (!visited[arrayList.get(0)]) {
                    queue.add(new int[]{arrayList.get(0), arrayList.get(1) + rem[1]});
                }
            }
        }
        return ans;
    }

    public static int dijkastra1(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 3 != 0) {
                while (n % 3 != 0) {
                    n = n - 1;
                    System.out.println(n);
                    count++;
                }
            } else {
                n = n / 3;
                System.out.println(n);
                count++;
            }

        }
        return count - 1;
    }

    //    https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1
    public int minOperation(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 0)
                n = n / 2;
            else
                n = n - 1;
            count++;
        }
        return count;
    }


    public int minSteps(int N) {
        // wrong solution
//        int count = 0;
//        while (n > 1) {
//            if (n % 3 == 0)
//                n = n / 3;
//            else if (n % 2 == 0)
//                n = n / 2;
//            else
//                n = n-1;
//            count++;
//        }
//        return count;

        // right solution
        int[] dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            int temp;
            if (i % 2 == 0 && i % 3 == 0) {
                temp = Math.min(dp[i / 2], dp[i / 3]);
            } else if (i % 2 == 0) {
                temp = dp[i / 2];
            } else if (i % 3 == 0) {
                temp = dp[i / 3];
            } else {
                temp = dp[i - 1];
            }
            dp[i] = Math.min(temp, dp[i - 1]) + 1;
        }
        return dp[N];
    }

}
