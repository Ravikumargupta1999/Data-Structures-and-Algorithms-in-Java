import java.util.LinkedList;
import java.util.Queue;

public class Video_6_As_Far_from_Land_as_Possible {

//https://leetcode.com/problems/as-far-from-land-as-possible/
    class Pair {
        int i;
        int j;
        int level;

        Pair(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxDistance(int[][] mat) {

        Queue<Pair> queue = new LinkedList<>();
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    queue.add(new Pair(i, j, 0));
                    mat[i][j] = -1;
                    count1++;
                } else
                    count0++;
            }
        }
        if (count0 == mat.length * mat[0].length || count1 == mat.length * mat[0].length)
            return -1;
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Pair temp = queue.poll();
                for (int i = 0; i < dirs.length; i++) {
                    int rowdish = temp.i + dirs[i][0];
                    int coldish = temp.j + dirs[i][1];
                    if (rowdish >= 0 && coldish >= 0 && rowdish < mat.length && coldish < mat[0].length && mat[rowdish][coldish] == 0) {
                        mat[rowdish][coldish] = temp.level + 1;
                        queue.add(new Pair(rowdish, coldish, temp.level + 1));
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] > max)
                    max = mat[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n\n");

        Video_6_As_Far_from_Land_as_Possible a = new Video_6_As_Far_from_Land_as_Possible();

        a.maxDistance(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n\n");
    }
}
