//import javafx.animation.PauseTransition;

import java.util.ArrayList;
import java.util.LinkedList;

public class Video_11_Zero_One_BFS {
    static class Pair {
        int vertex;
        int weight;

        public Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1}, {}, {1, 3}, {}, {5}, {1}, {3, 4}};
        ArrayList<ArrayList<Pair>> arrayLists = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayLists.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int a = arr[i][j];
                arrayLists.get(i).add(new Pair(arr[i][j], 0));
                arrayLists.get(a).add(new Pair(i, 1));
            }
        }
        LinkedList<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        queue.addLast(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair rem = queue.removeFirst();
            if (rem.vertex == arr.length - 1) {
                System.out.println(rem.weight);
                return;
            }
            visited[rem.vertex] = true;

            for (Pair neighbours : arrayLists.get(rem.vertex)) {
                if (!visited[neighbours.vertex]) {
                    if (neighbours.weight == 0) {
                        queue.addFirst(new Pair(neighbours.vertex, rem.weight));
                    } else {
                        queue.addLast(new Pair(neighbours.vertex, rem.weight + 1));
                    }
                }
            }
        }
    }

}
