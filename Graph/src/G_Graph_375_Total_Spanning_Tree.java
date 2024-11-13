import java.util.ArrayList;

public class G_Graph_375_Total_Spanning_Tree {
    // Here we are not looking for weight as it no redunadent here
    static int spanningTree(int V, ArrayList<ArrayList<Integer>> adj) {

        // Calculate Adjacency Matrix
        int[][] adjacencyMatrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                int row = i;
                int col = neighbour;
                adjacencyMatrix[row][col] = 1;
            }
        }


        // Calculate Diagonal Matrix
        int[][] degreeMatrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjacencyMatrix[i][j] == 1)
                    degreeMatrix[i][i]++;
            }
        }


        //  // Calculate Resultant Matrix
        int[][] ans = new int[V - 1][V - 1];
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < V - 1; j++) {
                ans[i][j] = degreeMatrix[i + 1][j + 1] - adjacencyMatrix[i + 1][j + 1];
            }
        }
        printMatrix(ans);

        return 8;
    }

    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {0, 3}, {0, 3}, {0, 1, 2}};
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            arrayList.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            for (int val : arr[i]) {
                arrayList.get(i).add(val);
            }
        }
        spanningTree(arr.length, arrayList);

    }
}
