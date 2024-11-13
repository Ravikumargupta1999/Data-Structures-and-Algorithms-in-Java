import java.util.ArrayList;
import java.util.PriorityQueue;

public class P_5_Network_Delay_Time {
    // https://leetcode.com/problems/network-delay-time/submissions/912255486/
    public static int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int t = edge[2];

            graph.get(u).add(new int[]{v, t});
        }

        boolean[] visited = new boolean[n];

        int totalTime = 0;
        int node = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        queue.add(new int[]{k - 1, 0});



        while (queue.size() > 0) {

            int[] temp = queue.poll();
            if (visited[temp[0]])
                continue;
//            System.out.println(temp[0]+"   "+temp[1]);
            node++;
            visited[temp[0]] = true;
            totalTime = Math.max(temp[1], totalTime);

            for (int[] neighbour : graph.get(temp[0])) {
//                System.out.println(neighbour[0]+"    "+(temp[1] + neighbour[1]));
                queue.add(new int[]{neighbour[0], temp[1] + neighbour[1]});
            }
//            System.out.println("\n\n");

        }
        return node == n ? totalTime : -1;
    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times,4,2));
    }
}
