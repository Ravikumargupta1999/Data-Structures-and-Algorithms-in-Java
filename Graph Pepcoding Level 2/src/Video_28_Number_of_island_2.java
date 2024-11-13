import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/number-of-island-2-official/ojquestion
// https://www.youtube.com/watch?v=PcYCkgYu6uc&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=28
public class Video_28_Number_of_island_2 {


    public static int[] numOfIslandsII(int n, int m, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] par = new int[m * n];
        int[] rank = new int[m * n];
        Arrays.fill(par, -1);
        int count = 0;
        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            int cellno = row * n + col;
            if (par[cellno] != -1) {
                ans.add(count);
                continue;
            }
            par[cellno] = cellno;
            rank[cellno] = 1;
            count++;
            for (int[] dir : dirs) {
                int rowDish = row + dir[0];
                int colDish = col + dir[1];
                int cellDish = rowDish * n + colDish;
                if (rowDish < 0 || colDish < 0 || rowDish >= m || colDish >= n || par[cellDish] == -1) {

                    // par[cellDish] == -1  means mat[rowdish][coldish] is not processed i.e it is not 1
                    continue;
                }
                int lx = find(cellno, par);
                int ly = find(cellDish, par);
                if (lx != ly) {
                    if (rank[lx] > rank[ly]) {
                        par[ly] = lx;
                    } else if (rank[lx] < rank[ly]) {
                        par[lx] = ly;
                    } else {
                        par[ly] = lx;
                        rank[lx]++;
                    }
                    count--;
                }
            }
            ans.add(count);
        }
        int[] answer = new int[ans.size()];
        for (int i=0;i<answer.length;i++)
            answer[i] = ans.get(i);
        return answer;
    }

    public static int find(int x, int[] par) {
        if (par[x] == x)
            return x;
        return par[x] = find(par[x], par);
    }
}
