import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1#
public class Euler_circuit_and_Path {
    public int isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        int edges = 0;
        int[] inDegree = new int[v];
        for (ArrayList<Integer> al : adj) {
            for (int i = 0; i < al.size(); i++) {
                edges++;
                inDegree[al.get(i)]++;
            }
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < v; i++) {
            if (inDegree[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if (even == v) {
            if (edges != 0)
                return 2;
            else
                return 0;
        }
        if (odd == 2)
            return 1;
        else
            return 0;
    }
    // https://practice.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1#
    public boolean isEularCircuitExist1(int v, ArrayList<ArrayList<Integer>> adj)
    {
        int edges = 0;
        int[] inDegree = new int[v];
        for (ArrayList<Integer> al : adj) {
            for (int i = 0; i < al.size(); i++) {
                edges++;
                inDegree[al.get(i)]++;
            }
        }
        int odd = 0;
        int even = 0;
        for (int i = 0; i < v; i++) {
            if (inDegree[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        if (even == v)

            return true;

        else
            return false;
    }
}
