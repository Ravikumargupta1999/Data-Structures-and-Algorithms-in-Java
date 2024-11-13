import java.util.ArrayList;

// https://www.codingninjas.com/codestudio/problems/number-of-triangles-in-directed-and-undirected-graphs_1214931?leftPanelTab=2
// https://www.youtube.com/watch?v=2Fb0kPngzMw&t=332s
public class G_Graph_397_Number_Of_Triangles_In_Directed_And_Undirected_Graphs {
    public static int[] countTriangles(int v1, ArrayList<ArrayList<Integer>> edgeListOfDirectedGraph, int v2, ArrayList<ArrayList<Integer>> edgeListOfUnDirectedGraph) {
        int[] ans = new int[2];

        int[][] arr1 = new int[v1][v1];
        for (ArrayList<Integer> al : edgeListOfDirectedGraph) {
            int i = al.get(0);
            int val = al.get(1);
            arr1[i][val] = 1;

        }

        int count1 = 0;
        for (int i = 0; i < v1; i++) {
            for (int j = 0; j < v1; j++) {
                for (int k = 0; k < v1; k++) {
                    if (arr1[i][j] == 1 && arr1[j][k] == 1 && arr1[k][i] == 1) {
                        count1++;
                    }
                }
            }
        }
        ans[0] = count1 / 3;

        int[][] arr2 = new int[v2][v2];
        for (ArrayList<Integer> edge : edgeListOfUnDirectedGraph) {
            int i = edge.get(0);
            int val = edge.get(1);
            arr2[i][val] = 1;
            arr2[val][i] = 1;


        }
        int count2 = 0;
        for (int i = 0; i < v2; i++) {
            for (int j = 0; j < v2; j++) {
                for (int k = 0; k < v2; k++) {
                    if (arr2[i][j] == 1 && arr2[j][k] == 1 && arr2[k][i] == 1) {
                        count2++;
                    }
                }
            }
        }
        ans[1] = count2 / 6;
        return ans;
    }
}
