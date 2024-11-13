import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/
public class Video_4_Zero_One_01_Matrix {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void updateMatrix(int[][] mat) {
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (queue.size() > 0) {
            Pair temp = queue.poll();
            for (int i = 0; i < dirs.length; i++) {
                int rowDish = temp.i + dirs[i][0];
                int colDish = temp.j + dirs[i][1];
                if (rowDish >= 0 && colDish >= 0 && rowDish < mat.length && colDish < mat[0].length && mat[rowDish][colDish] < 0) {
                    mat[rowDish][colDish] = mat[temp.i][temp.j] + 1;
                    queue.add(new Pair(rowDish, colDish));
                }
            }
        }
//        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n\n");

        Video_4_Zero_One_01_Matrix a = new Video_4_Zero_One_01_Matrix();

        a.updateMatrix(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n\n");
    }
}
