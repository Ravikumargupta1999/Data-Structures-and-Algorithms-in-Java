import java.util.List;

public class P_7_Keys_and_Rooms {
    // https://leetcode.com/problems/keys-and-rooms/submissions/912296571/
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(0, visited, rooms);

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i])
                return false;
        }
        return true;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> rooms) {
        visited[node] = true;

        for (int key : rooms.get(node)) {
            if (!visited[key]) {
                dfs(key, visited, rooms);
            }
        }
    }
}
