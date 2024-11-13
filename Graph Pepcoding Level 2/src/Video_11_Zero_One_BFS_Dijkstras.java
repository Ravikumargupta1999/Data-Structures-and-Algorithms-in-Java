import java.util.ArrayList;
import java.util.PriorityQueue;

public class Video_11_Zero_One_BFS_Dijkstras {
    public static void main(String[] args) {
        int n = 7;
        int source = 0;
        int target = 6;
        int[][] connection = {{1}, {}, {1, 3}, {}, {5}, {}, {3, 4}};
        ArrayList<ArrayList<Integer[]>> newGraph;
        newGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newGraph.add(new ArrayList<Integer[]>());
        }

        for (int i = 0; i < connection.length; i++) {
            for (int j = 0; j < connection[i].length; j++) {

                newGraph.get(i).add(new Integer[]{connection[i][j], 0});
                newGraph.get(connection[i][j]).add(new Integer[]{i, 1});

            }
        }
        printGraph(newGraph);


        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        boolean[] visited = new boolean[n];
        priorityQueue.add(new Integer[]{source, 0});
        visited[source] = true;
        while (!priorityQueue.isEmpty()) {
            Integer[] temp = priorityQueue.poll();
            System.out.println(temp[0]+"  "+temp[1]);
            if (temp[0] == target) {
                System.out.println("The No edge to be reversed : " + temp[1]);
                return;
            }
            for (Integer[] arr : newGraph.get(temp[0])) {
                if (!visited[arr[0]]) {
                    visited[arr[0]] = true;
                    priorityQueue.add(new Integer[]{arr[0], temp[1] + arr[1]});
                }
            }
        }
        System.out.println("Not Possible To reach");
    }

    public static void printGraph(ArrayList<ArrayList<Integer[]>> graph) {


        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Node " + i + " : ");
            for (Integer[] a : graph.get(i)) {
                System.out.println("          " + i + " -- " + a[0] + " --> " + a[1]);
            }
            System.out.println("");
        }
    }
}
